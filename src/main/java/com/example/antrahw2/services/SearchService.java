package com.example.antrahw2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class SearchService
{
    private final RestTemplate rt;
    @Value("${hipolab.base.url}")
    private String baseURL;
    @Autowired
    public SearchService(RestTemplate rt) {
        this.rt = rt;
    }

    public String getAll() { // blocking get all
        return rt.getForObject(baseURL, String.class);
    }

    public String getSync(List<String> countries) {
        return countries.stream()
                .map(this::sendRequestSync) // 使用同步方法发送请求
                .map(result -> result.substring(1, result.length() - 1)) // 删除每个结果的首尾括号
                .collect(Collectors.joining(",")); // 将结果拼接成一个字符串
    }

    public String sendRequestSync(String country) {
        String result = rt.getForObject(baseURL + "?country=" + country, String.class);
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    public CompletableFuture<String> sendRequestAsync(String country) {
        // 模拟异步请求
        return CompletableFuture.supplyAsync(() -> {
            return rt.getForObject(baseURL + "?country=" + country, String.class);
        });
    }

    public CompletableFuture<String> getAsync(List<String> countries) { // async get all
        List<CompletableFuture<String>> futures = countries.stream()
                .map(this::sendRequestAsync)
                .toList();
        CompletableFuture<?> allDone = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0]));
        return  allDone.thenApply(v -> "[" + futures.stream()
                .map(CompletableFuture::join)
                .map(result -> result.substring(1, result.length()-1))
                .collect(Collectors.joining(","))  + "]");
    }
}
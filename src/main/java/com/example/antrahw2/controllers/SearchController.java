package com.example.antrahw2.controllers;

import com.example.antrahw2.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class SearchController {
    private final SearchService searchService;
    @Autowired
    public  SearchController(SearchService ss) {this.searchService = ss;};

    @GetMapping("/sync/getAll")
    public ResponseEntity<String> getAll(){
        return new ResponseEntity<>(searchService.getAll(), HttpStatus.OK);
//        return new ResponseEntity<>("Hello, world", HttpStatus.OK);
    }

    @GetMapping("/sync/get")
    public ResponseEntity<String> getSync(@RequestParam("country") List<String> countries){
        return new ResponseEntity<>(searchService.getSync(countries), HttpStatus.OK);
    }

    @GetMapping("/async/get")
    public ResponseEntity<String> getAsync(@RequestParam("country") List<String> countries) throws ExecutionException, InterruptedException{
        CompletableFuture<String> future = searchService.getAsync(countries);
        return new ResponseEntity<>(future.get(), HttpStatus.OK);
    }
}
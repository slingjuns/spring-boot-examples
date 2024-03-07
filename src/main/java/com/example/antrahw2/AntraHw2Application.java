package com.example.antrahw2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AntraHw2Application {
	private final RestTemplateBuilder builder;

	@Autowired
	public AntraHw2Application(RestTemplateBuilder builder){
		this.builder = builder;
	}

	@Bean
	public RestTemplate restTemplate(){
		return builder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(AntraHw2Application.class, args);
	}

}

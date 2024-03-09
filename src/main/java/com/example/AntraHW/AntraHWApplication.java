package com.example.AntraHW;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AntraHWApplication {
	private final RestTemplateBuilder builder;

	@Autowired
	public AntraHWApplication(RestTemplateBuilder builder){
		this.builder = builder;
	}

	@Bean
	public RestTemplate restTemplate(){
		return builder.build();
	}

	@Bean

	public static void main(String[] args) {
		SpringApplication.run(AntraHWApplication.class, args);
	}

}

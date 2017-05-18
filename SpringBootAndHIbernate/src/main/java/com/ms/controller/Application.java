package com.ms.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages={"com.ms.controller","com.ms.dao","com.ms.service"})
@EnableJpaRepositories(basePackages = "com.ms.dao")
@EntityScan(basePackages = "com.ms.pojo")
@SpringBootApplication
public class Application {
	
	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(Application.class, args);
		
	}

}


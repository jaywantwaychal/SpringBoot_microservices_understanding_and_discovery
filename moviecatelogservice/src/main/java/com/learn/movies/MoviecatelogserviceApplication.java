package com.learn.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MoviecatelogserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviecatelogserviceApplication.class, args);
	}

}

package com.cts.userdetails;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@Slf4j
public class UserDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDetailsApplication.class, args);
		log.info("UserDetail Microservice is running.........");
	}

}

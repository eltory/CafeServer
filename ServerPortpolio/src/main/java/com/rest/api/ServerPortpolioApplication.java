package com.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ServerPortpolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerPortpolioApplication.class, args);
	}
}

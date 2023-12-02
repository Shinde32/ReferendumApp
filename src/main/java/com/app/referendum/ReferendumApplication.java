package com.app.referendum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReferendumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReferendumApplication.class, args);
		
		System.out.println("referendum Application is Running");
	}
}

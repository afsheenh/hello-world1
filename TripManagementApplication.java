package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude=SecurityAutoConfiguration.class)
@EnableSwagger2
@EnableWebSecurity
public class TripManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripManagementApplication.class, args);
	}

}

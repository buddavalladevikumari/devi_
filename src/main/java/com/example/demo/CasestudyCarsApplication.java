package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
public class CasestudyCarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasestudyCarsApplication.class, args);
	}

}

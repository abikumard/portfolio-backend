package com.abikumar.portfoliobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class PortfoliobackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfoliobackendApplication.class, args);
	}

}

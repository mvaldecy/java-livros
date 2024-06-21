package com.packt.carDatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarDatabaseApplication {
	private static final Logger logger = LoggerFactory.getLogger(
		CarDatabaseApplication.class
	);

	public static void main(String[] args) {
		// test dev tools
		SpringApplication.run(CarDatabaseApplication.class, args);
		logger.info("Application started");
	}

}

package com.packt.carDatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.packt.carDatabase.model.User;
import com.packt.carDatabase.model.UserRepository;

@SpringBootApplication
public class CarDatabaseApplication implements CommandLineRunner {
	private final UserRepository userRepository;

	public CarDatabaseApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	private static final Logger logger = LoggerFactory.getLogger(
		CarDatabaseApplication.class
	);

	@Override
	public void run(String... args) throws Exception {
		// userRepository.save(new User("admin", "$2y$10$G2RhJHgK9MCROgbpx.VIoODYUkvICjRNRyYXB/fXYdMurIlTfzFI.", "ADMIN"));
	}

	public static void main(String[] args) {
		// test dev tools
		SpringApplication.run(CarDatabaseApplication.class, args);
		logger.info("Application started");
		
	}
}

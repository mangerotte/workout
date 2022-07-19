package com.example.luizmangerotte.workout;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@Slf4j
public class WorkoutApplication {



	public static void main(String[] args) {
		log.info("Starting application");
		SpringApplication.run(WorkoutApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123"));;
		log.info("Aplication run");
	}

}

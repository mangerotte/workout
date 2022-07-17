package com.example.luizmangerotte.workout;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class WorkoutApplication {



	public static void main(String[] args) {
		log.info("Starting application");
		SpringApplication.run(WorkoutApplication.class, args);
		log.info("Aplication run");
	}

}

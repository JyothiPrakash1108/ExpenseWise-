package com.mjp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExpenseShareApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseShareApplication.class, args);
	}

}

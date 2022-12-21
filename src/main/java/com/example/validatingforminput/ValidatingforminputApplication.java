package com.example.validatingforminput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class ValidatingforminputApplication {
	private static final Logger log = LoggerFactory.getLogger(ValidatingforminputApplication.class);
	public static void main(String[] args) throws IllegalArgumentException {

		SpringApplication.run(ValidatingforminputApplication.class, args);
	}






}

package com.project.technicalTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.technicalTest.models.User;

import exceptions.ResourceNotFoundException;

@SpringBootApplication
@EnableWebMvc
public class TechnicalTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnicalTestApplication.class, args);
	}

}

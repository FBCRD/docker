package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DockerApplication {
	@GetMapping("/hello")
	public String hello() {
		return "Hello from Dockerized Spring Boot!";
	}
	@GetMapping("/aluno")
	public String aluno() {
		return "Aluno";
	}
	public static void main(String[] args) {
		SpringApplication.run(DockerApplication.class, args);
	}

}

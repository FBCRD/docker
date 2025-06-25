package com.example.demo;

import com.example.demo.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@SpringBootApplication
public class DockerApplication {
	@GetMapping("/")
	public String index(Model model) {
		UserRepository userRepository = null;
		model.addAttribute("usuarios", userRepository.findAll());
		return "index";
	}
	public static void main(String[] args) {
		SpringApplication.run(DockerApplication.class, args);
	}
}
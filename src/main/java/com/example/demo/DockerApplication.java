package com.example.demo;

import com.example.demo.model.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import com.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootApplication
public class DockerApplication {
	@GetMapping("/teste")
	public String teste() {
		return "Aplicação funcionando!";
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("usuario", userRepository.findAll());
		return "index";
	}

	@GetMapping("/add")
	public String addUserForm(Usuario user) {
		return "addUser";
	}

	@PostMapping("/add")
	public String addUser(Usuario user) {
		userRepository.save(user);
		return "redirect:/";
	}
	public static void main(String[] args) {
		SpringApplication.run(DockerApplication.class, args);
	}
}
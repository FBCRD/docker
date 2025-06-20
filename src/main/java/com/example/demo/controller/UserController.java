package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

//    @GetMapping("/")
//    public String teste() {
//        return "Aplicação funcionando!";
//    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("usuarios", userRepository.findAll());
        return "index";
    }
//
//    @GetMapping("/add")
//    public String addUserForm(Usuario user) {
//        return "addUser";
//    }
//
//    @PostMapping("/add")
//    public String addUser(Usuario user) {
//        userRepository.save(user);
//        return "redirect:/";
//    }
}
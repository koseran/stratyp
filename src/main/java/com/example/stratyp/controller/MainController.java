package com.example.stratyp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";  // Thymeleaf template name (login.html)
    }

}

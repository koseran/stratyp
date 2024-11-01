package com.example.stratyp.Controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        return "login";  // Thymeleaf template name (login.html)
    }

    @GetMapping("/dashboard")
    public String showDashboardPage(Model model) {
        return "index";  // Thymeleaf template name (login.html)
    }
}

package com.example.stratyp.controller;

import com.example.stratyp.Entity.User;
import com.example.stratyp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping(value= "/api")
public class DashboardController {

    private final UserService userService;


    @GetMapping("/dashboard")
    public String showDashboardPage(Model model, Principal principal) {
        // Ensure principal is not null before attempting to fetch the user
        if (principal != null) {
            // Fetch user details based on the logged-in username
            Optional<User> userOptional = userService.findByUsername(principal.getName());

            // Check if the user is present
            if (userOptional.isPresent()) {
                // Add the user to the model
                model.addAttribute("user", userOptional.get());
            }
        }
        System.out.println(principal.getName());
        return "index";  // Thymeleaf template name (e.g., dashboard.html)
    }

}

package com.example.stratyp.controller;


import com.example.stratyp.Entity.DeclarationMonths;
import com.example.stratyp.Entity.User;
import com.example.stratyp.repository.DeclarationMonthsRepository;
import com.example.stratyp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/api/user")
public class DeclarationUserController {

    private final DeclarationMonthsRepository declarationMonthsRepository;
    private final UserService userService;
    public DeclarationUserController(DeclarationMonthsRepository declarationMonthsRepository, UserService userService) {
        this.declarationMonthsRepository = declarationMonthsRepository;
        this.userService = userService;
    }

    @GetMapping("/declaration")
    public String getCalendarPage(Model model, Principal principal) {
        // Retrieve the logged-in user's username from Principal
        String username = principal.getName();
        System.out.println("Logged-in user: " + username);

        // Fetch user details from your database/service
        Optional<User> userOptional = userService.findByUsername(username);

        // Unwrap the Optional and handle if empty
        User user = userOptional.orElse(null); // or provide a default User

        // Add the User object to the model
        model.addAttribute("user", user);

        return "callendar"; // Ensure your template name is correct
    }
}


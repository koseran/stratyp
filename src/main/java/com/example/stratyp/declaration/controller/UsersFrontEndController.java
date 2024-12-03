package com.example.stratyp.declaration.controller;


import com.example.stratyp.declaration.repository.DeclarationRepository;
import com.example.stratyp.user.User;
import com.example.stratyp.user.UserRepository;
import com.example.stratyp.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/api")
public class UsersFrontEndController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final DeclarationRepository declarationRepository;

    @GetMapping("/militaryoffice/usersdeclaration")
    public String getMilitaryofficeUsersDeclaration(Model model, Principal principal){
        String username = principal.getName();

        // Fetch user details from your database/service
        Optional<User> userOptional = userService.findByUsername(username);

        // Unwrap the Optional and handle if empty
        User user = userOptional.orElse(null); // or provide a default User
        model.addAttribute("user", user);
        return "UsersDeclaration";
    }

}

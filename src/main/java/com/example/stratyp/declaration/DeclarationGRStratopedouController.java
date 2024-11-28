package com.example.stratyp.declaration;


import com.example.stratyp.user.User;
import com.example.stratyp.user.UserRepository;
import com.example.stratyp.user.UserService;
import jakarta.persistence.Access;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/api/admin")
public class DeclarationGRStratopedouController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/declaration")
    public String getCalendarPage(Model model, @org.jetbrains.annotations.NotNull Principal principal){

        // Retrieve the logged-in user's username from Principal
        String username = principal.getName();
        // Fetch user details from your database/service
        Optional<User> userOptional = userService.findByUsername(username);
        // Unwrap the Optional and handle if empty
        User user = userOptional.orElse(null); // or provide a default User
        if (user != null && user.getKvd_sg() != null) {
            // Add the User object to the model
            model.addAttribute("user", user);

            // Get all ASG Users
            Long kvdId = user.getKvd_sg().getId();  // assuming kvd_sg is a StratologikaGrafeia object
            List<User> asgUsers = userRepository.getAllAsgUsers(kvdId);
            model.addAttribute("ASGUsers", asgUsers);

            List<User> allUsers = userRepository.findAll();
            model.addAttribute("allUsers",allUsers);

        } else {
            model.addAttribute("declaration", null);  // No user or kvd_sg
        }

        return "calendar";
    }

}

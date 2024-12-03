package com.example.stratyp.declaration.controller;
//
//
//import com.example.stratyp.declaration.repository.DeclarationRepository;
//import com.example.stratyp.user.User;
//import com.example.stratyp.user.UserRepository;
//import com.example.stratyp.user.UserService;
//import lombok.AllArgsConstructor;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.security.Principal;
//import java.util.List;
//import java.util.Optional;
//
//@Controller
//@AllArgsConstructor
//@RequestMapping("/api/user")
//@PreAuthorize("hasRole('ROLE_USER')")
//public class DeclarationUserController {
//
//    private final DeclarationRepository declarationRepository;
//    private final UserService userService;
//
//    private final UserRepository userRepository;
//
//    @GetMapping("/declaration")
//    public String getCalendarPage(Model model, Principal principal) {
//        // Retrieve the logged-in user's username from Principal
//        String username = principal.getName();
//
//        // Fetch user details from your database/service
//        Optional<User> userOptional = userService.findByUsername(username);
//
//        // Unwrap the Optional and handle if empty
//        User user = userOptional.orElse(null); // or provide a default User
//
//
//        if (user != null && user.getKvd_sg() != null) {
//            // Add the User object to the model
//            model.addAttribute("user", user);
//
//            // Get the ID of the associated StratologikaGrafeia (kvd_sg)
//            Long kvdId = user.getKvd_sg().getId();  // assuming kvd_sg is a StratologikaGrafeia object
//            model.addAttribute("declarations", declarationRepository.findDeclarationsByASG(kvdId)); // Pass ID
//
//            // Get all ASG Users
//            List<User> asgUsers = userRepository.getAllAsgUsers(kvdId);
//            model.addAttribute("ASGUsers", asgUsers);
//        } else {
//            model.addAttribute("declaration", null);  // No user or kvd_sg
//        }
//        return "UserCalendar"; // Ensure your template name is correct
//    }
//}
//

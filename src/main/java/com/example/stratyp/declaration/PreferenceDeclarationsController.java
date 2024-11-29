package com.example.stratyp.declaration;


import com.example.stratyp.user.Role;
import com.example.stratyp.user.User;
import com.example.stratyp.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class PreferenceDeclarationsController {

    private final PreferenceDeclarationsService preferenceDeclarationsService;
    private final UserService userService;

    @PostMapping(value = "/addPreferenceDeclaration")
    public void addPreferenceDeclaration(@RequestBody PreferenceDeclarations preferenceDeclarations, Principal principal) {
        // Fetch the authenticated user by username
        Optional<User> user = userService.findByUsername(principal.getName());

        // Check if the user has a role that is not "USER"
        if (user.isPresent()) {
            User authenticatedUser = user.get();
            System.out.println(authenticatedUser.getRole());
            // Check if the authenticated user is a "USER"
            if (authenticatedUser.getRole() == Role.USER) {
                // For "USER" role, perform specific logic
                preferenceDeclarations.setUserID(authenticatedUser);
                // Save the preference declaration
                preferenceDeclarationsService.savePreferenceDeclarations(preferenceDeclarations);

            } else {
                // For admin or other roles (not "USER"), perform other logic
                // Optionally, you can perform different actions based on the role
                preferenceDeclarationsService.savePreferenceDeclarations(preferenceDeclarations); // Save the entity
            }
        } else {
            // Handle the case where the user is not found
            throw new RuntimeException("User not found");
        }

    }


    @PostMapping(value = "/deletePreferenceDeclaration")
    public void deletePreferenceDeclaration(@RequestBody PreferenceDeclarations preferenceDeclarations) {
        // Fetch the authenticated user by username

    }

}

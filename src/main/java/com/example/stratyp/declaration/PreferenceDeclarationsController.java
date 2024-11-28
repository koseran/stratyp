package com.example.stratyp.declaration;


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
        if (user.isPresent()) {
            preferenceDeclarations.setUserID(user.get()); // Set the User object
            preferenceDeclarationsService.savePreferenceDeclarations(preferenceDeclarations); // Save the entity
        } else {
            throw new RuntimeException("User not found");
        }
    }


    @PostMapping(value = "/deletePreferenceDeclaration")
    public void deletePreferenceDeclaration(@RequestBody PreferenceDeclarations preferenceDeclarations) {
        // Fetch the authenticated user by username

    }

}

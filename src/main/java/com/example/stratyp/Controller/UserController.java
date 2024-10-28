package com.example.stratyp.Controller;

import com.example.stratyp.*;
import com.example.stratyp.Entity.User;
import com.example.stratyp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder; // Inject the PasswordEncoder

    @PostMapping(value = "/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        User savedUser = userService.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping(value = "/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestBody User user) {
        userService.deleteById(user.getId());
        return ResponseEntity.ok("User deleted");
    }

}

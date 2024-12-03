package com.example.stratyp.user;

import com.example.stratyp.user.User;
import com.example.stratyp.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {



    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Save a new user
    public User save(User user) {
        // Hash the password before saving
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // Find a user by ID
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    // Delete a user by ID
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            var userObj = user.get();

            // Assuming user.getRole() is a string representing the role (e.g., "USER", "ADMIN")
            // We prefix "ROLE_" to the role name to follow Spring Security's default conventions.
            String role = "ROLE_" + userObj.getRole();  // If getRole() returns "USER", we create "ROLE_USER"
            System.out.println("edo eisai" + role);
            org.springframework.security.core.userdetails.User u = (org.springframework.security.core.userdetails.User) org.springframework.security.core.userdetails.User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .authorities(List.of(new SimpleGrantedAuthority(role)) ) // Use SimpleGrantedAuthority to define roles
                    .build();

            return u;
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public Optional<User> findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}

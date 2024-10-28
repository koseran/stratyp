package com.example.stratyp.Service;

import com.example.stratyp.Entity.User;
import com.example.stratyp.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
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
            var UserObj = user.get();
            return org.springframework.security.core.userdetails.User.builder()
                    .username(UserObj.getUsername())
                    .password(UserObj.getPassword())
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    // Additional methods can be added as needed
}

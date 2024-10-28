package com.example.stratyp;


import com.example.stratyp.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private final UserService userService;

    @Bean
    public UserDetailsService userDetailsService() {
        return userService;
    }


    private static final String[] WHITE_LIST_URL = {
            "/",
            "/addUser",
            "/deleteUser",
    };

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())  // Disable CSRF protection for testing (not recommended for production)
                .authorizeHttpRequests(request ->
                        request
                                .requestMatchers(WHITE_LIST_URL).permitAll()  // Allow public access to /addUser
                                .anyRequest().authenticated()               // All other requests require authentication
                )
                .formLogin(Customizer.withDefaults())  // Enable default form-based login
                .httpBasic(Customizer.withDefaults());   // Enable HTTP Basic authentication


        return http.build();
    }




    //    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable())  // Προσωρινή απενεργοποίηση του CSRF για Postman
//                .authorizeHttpRequests(request -> request.anyRequest().permitAll()); // Απενεργοποίηση ελέγχου πρόσβασης
//
//        return http.build();
//    }


}

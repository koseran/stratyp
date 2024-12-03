package com.example.stratyp.security;


import com.example.stratyp.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import java.util.Locale;
@Configuration
@AllArgsConstructor
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private final UserService userService;

    @Bean
    public UserDetailsService userDetailsService() {
        return userService;
    }

    private static final String[] WHITE_LIST_URL = {
            "/",
            "/login",
            "/adduser",
            "/error",
            "/assets/bootstrap/**",
            "/assets/bootstrap/css/**",
            "/assets/bootstrap/js/**",
            "/assets/images/**"
    };

    @Bean
    public AuthenticationProvider authenticationProvider() {
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
                                .requestMatchers(WHITE_LIST_URL).permitAll()  // Allow public access to specified URLs
                                .anyRequest().authenticated()  // All other requests require authentication
                )
                .formLogin(form ->
                        form
                                .loginPage("/login")  // Specify the custom login page
                                .failureUrl("/login?error=true")  // Redirect here on login failure
                                .permitAll()
                                .successHandler(authenticationSuccessHandler())  // Use custom authentication handler
                )
                .httpBasic(Customizer.withDefaults());  // Optional: Enable HTTP Basic authentication

        return http.build();
    }

    private AuthenticationSuccessHandler authenticationSuccessHandler() {
        return (request, response, authentication) -> {
            var roles = authentication.getAuthorities();
            System.out.println(roles);
            roles.forEach(role -> System.out.println("Role: " + role.getAuthority())); // Debugging roles

            if (roles.stream().anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"))) {
                response.sendRedirect("/api/admin/declaration");
            } else if (roles.stream().anyMatch(role -> role.getAuthority().equals("ROLE_USER"))) {
                response.sendRedirect("/api/user/declaration");
            } else if (roles.stream().anyMatch(role -> role.getAuthority().equals("ROLE_MILITARY_OFFICE_MANAGER"))) {
                response.sendRedirect("/api/militaryoffice/declaration");
            } else {
                response.sendRedirect("/");  // Default redirect
            }
        };
    }
}

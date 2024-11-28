package com.example.stratyp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class StratypApplication {

    public static void main(String[] args) {
        SpringApplication.run(StratypApplication.class, args);
    }


}

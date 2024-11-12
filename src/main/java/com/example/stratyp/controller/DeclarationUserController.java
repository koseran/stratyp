package com.example.stratyp.controller;


import com.example.stratyp.Entity.DeclarationMonths;
import com.example.stratyp.repository.DeclarationMonthsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/api/user")
public class DeclarationUserController {

    private final DeclarationMonthsRepository declarationMonthsRepository;
    public DeclarationUserController(DeclarationMonthsRepository declarationMonthsRepository) {
        this.declarationMonthsRepository = declarationMonthsRepository;
    }


    @GetMapping("declaration")
    public String getCalendarPage(Model model) {
        DeclarationMonths activeDeclaration = declarationMonthsRepository.findByIsActive(true).get(0);
        String monthDate = activeDeclaration.getMonth();  // Optional: keep if needed
        Date usersActiveDate = activeDeclaration.getUsers_active_date();

        model.addAttribute("userDate", monthDate);       // Keep if you need `monthDate`
        model.addAttribute("usersActiveDate", usersActiveDate); // Pass `users_active_date` to the view

        return "callendar"; // Return the name of the HTML file without .html extension
    }
}

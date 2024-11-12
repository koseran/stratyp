package com.example.stratyp.controller;

import com.example.stratyp.Entity.DeclarationMonths;
import com.example.stratyp.repository.DeclarationMonthsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/user/declaration-months")
public class DeclarationMonthsController {

    @Autowired
    private DeclarationMonthsRepository declarationMonthsRepository;

    @GetMapping
    public List<DeclarationMonths> getActiveDeclarationMonths() {
        return declarationMonthsRepository.findByIsActive(true); // Επιστρέφει μόνο τους ενεργούς μήνες
    }
}

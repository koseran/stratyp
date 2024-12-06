package com.example.stratyp.declaration.controller;


import com.example.stratyp.declaration.entity.Declarations;
import com.example.stratyp.declaration.repository.DeclarationRepository;
import com.example.stratyp.user.*;
import lombok.AllArgsConstructor;
import org.hibernate.query.Order;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/api")
public class UsersFrontEndController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final DeclarationRepository declarationRepository;
    private final ServiceRoleRepository serviceRoleRepository;
    private final MilitaryRankRepository militaryRankRepository;

    @GetMapping("/militaryoffice/usersdeclaration")
    public String getMilitaryofficeUsersDeclaration(Model model, Principal principal) {

        //Set User
        String username = principal.getName();
        Optional<User> userOptional = userService.findByUsername(username);
        User user = userOptional.orElse(null);
        model.addAttribute("user", user);

        //Set Months Days

        List<Declarations> allDeclarations = declarationRepository.findAll(Sort.by(Sort.Order.asc("declarationDate")));
        List<MilitaryRank> militaryRanks = militaryRankRepository.findAll(Sort.by(Sort.Order.asc("id")));
        model.addAttribute("serviceRole", serviceRoleRepository);
        model.addAttribute("allDeclarations", allDeclarations);
        model.addAttribute("militaryRanks", militaryRanks);



        return "UsersDeclarationNew";
    }
}



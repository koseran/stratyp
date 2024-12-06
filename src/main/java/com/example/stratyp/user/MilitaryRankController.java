package com.example.stratyp.user;

import com.example.stratyp.declaration.entity.DeclarationMonths;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/active-military-ranks")
public class MilitaryRankController {

    private MilitaryRankRepository militaryRankRepository;

    @GetMapping
    public List<MilitaryRank> getActiveDeclarationMonths() {
        return militaryRankRepository.findAll(Sort.by(Sort.Order.asc("id")));
    }

}

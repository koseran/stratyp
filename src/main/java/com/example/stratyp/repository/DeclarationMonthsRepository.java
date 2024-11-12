package com.example.stratyp.repository;

import com.example.stratyp.Entity.DeclarationMonths;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeclarationMonthsRepository extends JpaRepository<DeclarationMonths, Long> {
    List<DeclarationMonths> findByIsActive(boolean isActive);
}
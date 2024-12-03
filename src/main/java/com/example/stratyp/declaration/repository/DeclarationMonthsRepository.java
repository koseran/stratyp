package com.example.stratyp.declaration.repository;

import com.example.stratyp.declaration.entity.DeclarationMonths;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeclarationMonthsRepository extends JpaRepository<DeclarationMonths, Long> {
    List<DeclarationMonths> findByIsActive(boolean isActive);


    @Query("SELECT DM.maxMonthDeclaration FROM DeclarationMonths DM WHERE DM.month = :month AND DM.year = :year")
    long countMaxMonthDecleration(@Param("month") String month, @Param("year") String year);


}
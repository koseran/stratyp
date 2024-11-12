package com.example.stratyp.repository;

import com.example.stratyp.Entity.PreferenceDeclarations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PreferenceDeclarationsRepository extends JpaRepository<PreferenceDeclarations, Long> {
}

package com.example.stratyp.declaration;

import com.example.stratyp.declaration.PreferenceDeclarations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PreferenceDeclarationsRepository extends JpaRepository<PreferenceDeclarations, Long> {
}

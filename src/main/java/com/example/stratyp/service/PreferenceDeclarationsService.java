package com.example.stratyp.service;


import com.example.stratyp.Entity.PreferenceDeclarations;
import com.example.stratyp.repository.PreferenceDeclarationsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PreferenceDeclarationsService {

    private final PreferenceDeclarationsRepository preferenceDeclarationsRepository;


    public void savePreferenceDeclarations(PreferenceDeclarations preferenceDeclarations) {
        preferenceDeclarationsRepository.save(preferenceDeclarations);
    }
}

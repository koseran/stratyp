package com.example.stratyp.declaration;


import com.example.stratyp.declaration.PreferenceDeclarations;
import com.example.stratyp.declaration.PreferenceDeclarationsRepository;
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

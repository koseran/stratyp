package com.example.stratyp.declaration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class DeclarationService {

    private final DeclarationRepository declarationRepository;

    public List<Declarations> getDeclarationsByUser(String username) {
        // Λογική για λήψη των δηλώσεων από έναν συγκεκριμένο χρήστη
        return null; // Επιστρέφει μια λίστα με δηλώσεις
    }

    public void saveUserDeclaration(Declarations declaration) {
        // Λογική για αποθήκευση της δήλωσης
        declarationRepository.save(declaration);
    }

    public void deleteUserDeclaration(Declarations declaration) {
        // Λογική για διαγραφή της δήλωσης
        declarationRepository.delete(declaration);
    }


}

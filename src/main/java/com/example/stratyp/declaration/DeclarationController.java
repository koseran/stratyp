package com.example.stratyp.declaration;

import com.example.stratyp.user.User;
import com.example.stratyp.user.UserRepository;
import com.example.stratyp.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class DeclarationController {




    private final DeclarationRepository declarationRepository;

    private final DeclarationMonthsRepository declarationMonthsRepository;

    private final DeclarationService declarationService;
    private final UserService userService;

    @PostMapping("/declaration/addDeclaration")
    public ResponseEntity<String> savePinnedDates(@RequestBody List<Declarations> pinnedDateRequests, Principal principal) {
        try {
            // Βρίσκουμε τον τρέχοντα χρήστη
            User currentUser = userService.findByUsername(principal.getName())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            for (Declarations pinnedDateRequest : pinnedDateRequests) {
                // Συνδέουμε τη δήλωση με τον χρήστη
                pinnedDateRequest.setUser(currentUser);

                // Ελέγχουμε αν υπάρχει ήδη δήλωση για την ίδια ημέρα
                Optional<Declarations> existingDeclaration = declarationRepository.findByUserAndDate(
                        currentUser.getId(),
                        pinnedDateRequest.getDeclarationDate()
                );

                if (existingDeclaration.isPresent()) {
                    return ResponseEntity.badRequest().body(
                            "Έχετε ήδη δηλώσει την ημέρα: " + pinnedDateRequest.getDeclarationDate() + " παρακαλώ πολυ αποεπιλέξτε την ημέρα ωστε να μπορείτε να συνεχίσετε"
                    );
                }
                
                // Ελέγχουμε το πλήθος δηλώσεων για τον τρέχοντα μήνα
                Date declarationDate = pinnedDateRequest.getDeclarationDate();
                Calendar cal = Calendar.getInstance();
                cal.setTime(declarationDate);
                int month = cal.get(Calendar.MONTH) + 1; // Μήνας
                int year = cal.get(Calendar.YEAR); // Έτος

                long declarationCount = declarationRepository.countDeclarationsForUserInMonth(
                        currentUser.getId(),
                        month,
                        year
                );

                System.out.println(String.valueOf(month) );
                long maxMonthDeclaration = declarationMonthsRepository.countMaxMonthDecleration(String.valueOf(month),String.valueOf(year));
                System.out.println(maxMonthDeclaration);
                if (declarationCount >= maxMonthDeclaration) {
                    return ResponseEntity.badRequest().body("Έχετε ήδη υποβάλει τον μέγιστο αριθμό 14 δηλώσεων για τον μήνα (ο αριθμός δηλώσεων σας είναι: " + declarationCount + "). ");
                }

                // Αποθηκεύουμε τη δήλωση
                declarationService.saveUserDeclaration(pinnedDateRequest);
            }

            return ResponseEntity.ok("Οι δηλώσεις αποθηκεύτηκαν με επιτυχία!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Σφάλμα κατά την αποθήκευση των δηλώσεων: " + e.getMessage());
        }
    }


}
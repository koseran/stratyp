package com.example.stratyp.Entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "preference_declarations_audit")
public class PreferenceDeclarationsAUDIT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Use ManyToOne if multiple declarations can belong to one user
    @JoinColumn(name = "user_id", nullable = false) // Specify foreign key column
    private User userID;

    @ManyToOne // Use ManyToOne if multiple declarations can belong to one user
    @JoinColumn(name = "preference_declarations_id", nullable = false) // Specify foreign key column
    private PreferenceDeclarations preferenceDeclarationsID;
    @Column(nullable = false)
    private Date auditDate;


}

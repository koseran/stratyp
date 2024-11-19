package com.example.stratyp.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name= "preference_declarations ")
 public class PreferenceDeclarations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date startDate;
    private Date endDate;
    private String reason;
    private String comment;
   @ManyToOne // Use ManyToOne if multiple declarations can belong to one user
   @JoinColumn(name = "user_id", nullable = false) // Specify foreign key column
   private User userID; // Store the full User object
}

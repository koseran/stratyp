package com.example.stratyp.declaration.entity;

import com.example.stratyp.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name="declarations")
public class Declarations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Μια δήλωση ανήκει σε έναν χρήστη
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Το πεδίο user_id συνδέει τη δήλωση με τον χρήστη
    private User user;

    @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Μορφή για την ημερομηνία από το JSON
    private Date declarationDate;

    @NonNull
    private String declarationType;

    private String declarationDetails;

}

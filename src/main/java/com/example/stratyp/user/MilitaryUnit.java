package com.example.stratyp.user;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "military_units")
public class MilitaryUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;           // Όνομα μονάδας
    private String abbreviation;    // Συντομογραφία
    @ManyToOne
    @JoinColumn(name = "branch_id") // Foreign key για τον κλάδο
    private MilitaryBranch branch;  // Σχέση με τον κλάδο
}

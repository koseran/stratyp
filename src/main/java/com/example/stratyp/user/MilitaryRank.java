package com.example.stratyp.user;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "military_ranks")
public class MilitaryRank {
    @Id
    private Long id;

    private String abbreviation;    // Συντομογραφία
    private String name;

    @ManyToOne
    @JoinColumn(name = "branch_id") // Foreign key για τον κλάδο
    private MilitaryBranch branch;  // Σχέση με τον κλάδο
}

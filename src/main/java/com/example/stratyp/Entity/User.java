package com.example.stratyp.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "rank_id") // Ορίζει το foreign key για τον βαθμό
    private MilitaryRank rank;

    @ManyToOne
    @JoinColumn(name = "unit_id") // Ορίζει το foreign key για το Σώμα/Όπλο
    private MilitaryUnit unit;

    @Enumerated(EnumType.STRING)
    private Role role; // Χρησιμοποιούμε το Enum Role
    @Column(unique = true , nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;




}

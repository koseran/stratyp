package com.example.stratyp.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

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
    @JoinColumn(name = "kvd_sg")
    private StratologikaGrafeia kvd_sg;

    @ManyToOne
    @JoinColumn(name = "service_role_id")
    private ServiceRole serviceRoleId;

    @ManyToOne
    @JoinColumn(name = "service_military_unit")
    private ServiceMilitaryUnit serviceMilitaryUnit;

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

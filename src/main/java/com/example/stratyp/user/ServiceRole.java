package com.example.stratyp.user;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;

@Data
@Entity
@Table(name = "service_role")
@Comment("Περιέχει τον τύπο Υπηρεσίας π.χ Βεας, Σκοπός ")
public class ServiceRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String roleName;
    private String abbreviation;

}

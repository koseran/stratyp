package com.example.stratyp.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "service_role")
public class ServiceRole {  //Περιέχει τον τύπο Υπηρεσίας π.χ Βεας, Σκοπός
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String roleName;
    @Column(nullable = false)
    private Boolean isActive;

}

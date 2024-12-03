package com.example.stratyp.declaration.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "declaration_months")
public class DeclarationMonths {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String month;
    private String year;
    private Date users_active_date;
    private Date tmhmatarxhs_active_date;
    private long maxMonthDeclaration;
    private boolean isActive;


}

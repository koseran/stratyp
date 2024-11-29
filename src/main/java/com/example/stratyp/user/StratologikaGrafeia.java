package com.example.stratyp.user;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "stratologika_grafeia")
public class StratologikaGrafeia {

    @Id
    private Long id; // πχ 241
    @Column(name = "sg_name", nullable = false, length = 100)
    private String sgName; // ΣΥ Αττικής
}

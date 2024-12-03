package com.example.stratyp.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "service_military_unit")
public class ServiceMilitaryUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String unitName;

    @ManyToOne
    @JoinColumn(name = "unit_branch_id")
    private MilitaryBranch unitBranchId;

}

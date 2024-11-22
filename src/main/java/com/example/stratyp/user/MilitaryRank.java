package com.example.stratyp.user;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "military_ranks")
public class MilitaryRank {
    @Id
    private Long id;
    private String name;
}

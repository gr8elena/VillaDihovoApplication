package com.example.villadihovo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@PrimaryKeyJoinColumn(name = "payment_id")
public class online extends payment{

    @Column(nullable = false, unique = true)
    private String card_number;

}

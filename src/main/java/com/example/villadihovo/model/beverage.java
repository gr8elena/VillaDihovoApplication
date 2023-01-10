package com.example.villadihovo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class beverage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int beverage_id;

    @Column(nullable = false)
    private String beverage_type;

    @Column(nullable = false)
    private float price;
}

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
public class meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int meal_id;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private String meal_type;
}

package com.example.villadihovo.model.offers;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int meal_id;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private String meal_type;
}

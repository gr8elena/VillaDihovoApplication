package com.example.villadihovo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(PreparedMealId.class)
public class prepared_meal {

    @Id
    @ManyToOne
    @JoinColumn(name = "meal_id", nullable = false)
    private meal meal;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int prepared_meal_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private user_table user_id;
}

package com.example.villadihovo.model.offers;

import com.example.villadihovo.model.users.UserTable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(PreparedMealId.class)
@Table(name="prepared_meal")
public class PreparedMeal {

    @Id
    @ManyToOne
    @JoinColumn(name = "meal_id", nullable = false)
    private Meal meal;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int prepared_meal_id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserTable user_id;
}

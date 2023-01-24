package com.example.villadihovo.model.offers;

import lombok.Data;

import java.io.Serializable;

@Data
public class PreparedMealId implements Serializable {

    private Meal meal;
    private int prepared_meal_id;
}

package com.example.villadihovo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class PreparedMealId implements Serializable {

    private meal meal;
    private int prepared_meal_id;
}

package com.example.villadihovo.model.reservations;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReservationForPreparedMealId implements Serializable {

    private int reservation_id;

    private int prepared_meal_id;

    private int meal_id;
}

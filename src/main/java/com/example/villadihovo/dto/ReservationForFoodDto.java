package com.example.villadihovo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ReservationForFoodDto implements Serializable {
    private String full_name;
    private String meal_type;
    private int quantity;
    private float price;
    private int number_guests;
    private LocalDate start_date;
}

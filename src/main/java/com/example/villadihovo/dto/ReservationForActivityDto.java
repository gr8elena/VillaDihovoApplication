package com.example.villadihovo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ReservationForActivityDto {
    private String activity_type;
    private float price;
    private LocalDate start_date;
    private LocalDate end_date;
    private int number_of_interested_guests;
    private String activity_location;
}

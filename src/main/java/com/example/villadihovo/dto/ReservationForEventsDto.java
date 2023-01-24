package com.example.villadihovo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ReservationForEventsDto implements Serializable {
    private String event_type;
    private float price;
    private LocalDate start_date;
    private LocalDate end_date;
    private int number_of_interested_guests;
}

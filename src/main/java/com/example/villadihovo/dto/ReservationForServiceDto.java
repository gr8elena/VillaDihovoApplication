package com.example.villadihovo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ReservationForServiceDto {
    private String full_name;
    private String service_type;
    private float price;
    private LocalDate start_date;
    private LocalDate end_date;
}

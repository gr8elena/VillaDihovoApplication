package com.example.villadihovo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ReservationForRoomDto implements Serializable {
    private int reservation_id;
    private int room_id;
    private LocalDate start_date;
    private LocalDate end_date;
    private int number_guests;
    private int adults;
    private int children;
    private String room_type;
    private int price;
    private String name;
    private String full_name;
    private String phone_number;
}

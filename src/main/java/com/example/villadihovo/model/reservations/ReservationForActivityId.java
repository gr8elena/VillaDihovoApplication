package com.example.villadihovo.model.reservations;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReservationForActivityId implements Serializable {
    private int reservation_id;
    private int activity_id;
}

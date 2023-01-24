package com.example.villadihovo.model.reservations;

import lombok.Data;

import java.io.Serializable;

@Data
public class GuestMakeReservationId implements Serializable {
    private int user_id;
    private int reservation_id;
}

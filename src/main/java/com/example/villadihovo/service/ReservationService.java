package com.example.villadihovo.service;

import com.example.villadihovo.model.reservations.Reservation;
import com.example.villadihovo.model.users.UserTable;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    List<Reservation>allReservations();
    Reservation addReservation(LocalDate start_date, LocalDate end_date, Integer number_guests, Integer adults, Integer children, String payment_method, String card_number, Integer room_id, UserTable user_id, Integer price);
}

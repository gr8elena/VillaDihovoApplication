package com.example.villadihovo.service.reservation;

import com.example.villadihovo.dto.ReservationForRoomDto;

import java.time.LocalDate;
import java.util.List;

public interface GuestMakeReservationService {
    List<ReservationForRoomDto> findAllRoomReservations();
    ReservationForRoomDto findRoomReservationByReservationId(Integer id);
    ReservationForRoomDto updateRoomReservationById(Integer reservation_id, LocalDate start_date, LocalDate end_date, Integer adults, Integer children, Integer number_guests);
    void deleteReservationById(Integer reservation_id);
}

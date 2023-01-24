package com.example.villadihovo.service;

import com.example.villadihovo.dto.ReservationForRoomDto;

import java.util.List;

public interface GuestMakeReservationService {
    List<ReservationForRoomDto> findAllRoomReservations();
    ReservationForRoomDto findRoomReservationByReservationId(Integer id);
    ReservationForRoomDto updateRoomReservationById(Integer id, ReservationForRoomDto roomReservationDto);
}

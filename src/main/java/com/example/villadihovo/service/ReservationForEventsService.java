package com.example.villadihovo.service;

import com.example.villadihovo.dto.ReservationForActivityDto;
import com.example.villadihovo.dto.ReservationForEventsDto;

import java.util.List;

public interface ReservationForEventsService {
    List<ReservationForEventsDto> findAllEventReservations();
}

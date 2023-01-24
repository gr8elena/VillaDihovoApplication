package com.example.villadihovo.service;

import com.example.villadihovo.dto.ReservationForActivityDto;
import com.example.villadihovo.dto.ReservationForRoomDto;

import java.util.List;

public interface ReservationForActivityService {
    List<ReservationForActivityDto> findAllActivityReservations();
}

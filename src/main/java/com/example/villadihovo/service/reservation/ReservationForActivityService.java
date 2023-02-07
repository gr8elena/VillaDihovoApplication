package com.example.villadihovo.service.reservation;

import com.example.villadihovo.dto.ReservationForActivityDto;

import java.util.List;

public interface ReservationForActivityService {
    List<ReservationForActivityDto> findAllActivityReservations();
}

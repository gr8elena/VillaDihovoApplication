package com.example.villadihovo.service.reservation;

import com.example.villadihovo.dto.ReservationForFoodDto;
import com.example.villadihovo.dto.ReservationForServiceDto;

import java.util.List;

public interface ReservationForServiceService {
    List<ReservationForServiceDto> findAllServiceReservations();
}

package com.example.villadihovo.service.reservation;

import com.example.villadihovo.dto.ReservationForEventsDto;
import com.example.villadihovo.dto.ReservationForFoodDto;

import java.util.List;

public interface ReservationForPreparedMealService {
    List<ReservationForFoodDto> findAllFoodReservations();
}

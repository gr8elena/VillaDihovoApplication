package com.example.villadihovo.service.impl.reservationImpl;

import com.example.villadihovo.dto.ReservationForFoodDto;
import com.example.villadihovo.repository.reservation.ReservationForPreparedMealRepository;
import com.example.villadihovo.service.reservation.ReservationForPreparedMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationForPreparedMealServiceImpl implements ReservationForPreparedMealService {

    @Autowired
    private ReservationForPreparedMealRepository reservationForPreparedMealRepository;

    @Override
    public List<ReservationForFoodDto> findAllFoodReservations() {
        return this.reservationForPreparedMealRepository.findAllFoodReservationsDto();
    }
}

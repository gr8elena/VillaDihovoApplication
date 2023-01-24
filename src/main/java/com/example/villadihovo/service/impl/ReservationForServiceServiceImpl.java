package com.example.villadihovo.service.impl;

import com.example.villadihovo.dto.ReservationForServiceDto;
import com.example.villadihovo.repository.ReservationForPreparedMealRepository;
import com.example.villadihovo.repository.ReservationForServiceRepository;
import com.example.villadihovo.service.ReservationForServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationForServiceServiceImpl implements ReservationForServiceService {

    @Autowired
    private ReservationForServiceRepository reservationForServiceRepository;

    @Override
    public List<ReservationForServiceDto> findAllServiceReservations() {
        return this.reservationForServiceRepository.findAllServiceReservationsDto();
    }
}

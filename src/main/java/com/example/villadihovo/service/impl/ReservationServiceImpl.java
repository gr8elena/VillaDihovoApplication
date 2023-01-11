package com.example.villadihovo.service.impl;

import com.example.villadihovo.model.reservation;
import com.example.villadihovo.repository.ReservationRepository;
import com.example.villadihovo.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    ReservationRepository reservationRepository;

    @Override
    public List<reservation> allReservations() {
        return reservationRepository.findAll();
    }
}

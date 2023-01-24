package com.example.villadihovo.service.impl;

import com.example.villadihovo.dto.ReservationForEventsDto;
import com.example.villadihovo.repository.ReservationForEventsRepository;
import com.example.villadihovo.service.ReservationForEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationForEventsServiceImpl implements ReservationForEventsService {

    @Autowired
    private ReservationForEventsRepository reservationForEventsRepository;


    @Override
    public List<ReservationForEventsDto> findAllEventReservations() {
        return this.reservationForEventsRepository.findAllEventReservationsDto();
    }
}

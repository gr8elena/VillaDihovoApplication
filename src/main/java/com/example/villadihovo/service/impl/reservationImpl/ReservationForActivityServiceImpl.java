package com.example.villadihovo.service.impl.reservationImpl;

import com.example.villadihovo.dto.ReservationForActivityDto;
import com.example.villadihovo.repository.reservation.ReservationForActivityRepository;
import com.example.villadihovo.service.reservation.ReservationForActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationForActivityServiceImpl implements ReservationForActivityService {

    @Autowired
    private ReservationForActivityRepository reservationForActivityRepository;

    @Override
    public List<ReservationForActivityDto> findAllActivityReservations() {
        return this.reservationForActivityRepository.findAllActivityReservationsDto();
    }
}

package com.example.villadihovo.service.impl;

import com.example.villadihovo.dto.ReservationForRoomDto;
import com.example.villadihovo.repository.GuestMakeReservationRepository;
import com.example.villadihovo.service.GuestMakeReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestMakeReservationServiceImpl implements GuestMakeReservationService {

    @Autowired
    private GuestMakeReservationRepository guestMakeReservationRepository;

    @Override
    public List<ReservationForRoomDto> findAllRoomReservations() {
        return guestMakeReservationRepository.findAllRoomReservationsDTO();
    }
}

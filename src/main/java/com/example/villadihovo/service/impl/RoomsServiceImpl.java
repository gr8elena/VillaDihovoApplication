package com.example.villadihovo.service.impl;

import com.example.villadihovo.model.offers.Rooms;
import com.example.villadihovo.repository.RoomRepository;
import com.example.villadihovo.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomsServiceImpl implements RoomsService {
    @Autowired
    RoomRepository roomRepository;

    @Override
    public List<Rooms> getAvailableRooms() {
        return roomRepository.findAllByAvailabilityTrue();
    }

    @Override
    public List<Rooms> findAll() {
        return roomRepository.findAll();
    }
}

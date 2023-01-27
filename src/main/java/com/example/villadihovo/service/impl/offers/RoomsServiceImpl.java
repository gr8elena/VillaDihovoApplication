package com.example.villadihovo.service.impl.offers;

import com.example.villadihovo.model.offers.Rooms;
import com.example.villadihovo.repository.offers.RoomRepository;
import com.example.villadihovo.service.offers.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Rooms> findRoomById(Integer id) {
        return roomRepository.findById(id);
    }
}

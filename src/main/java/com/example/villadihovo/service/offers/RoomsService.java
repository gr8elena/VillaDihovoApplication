package com.example.villadihovo.service.offers;

import com.example.villadihovo.model.offers.Rooms;

import java.util.List;
import java.util.Optional;

public interface RoomsService {
    List<Rooms> getAvailableRooms();
    List<Rooms> findAll();
    Optional<Rooms> findRoomById(Integer id);
}

package com.example.villadihovo.service;

import com.example.villadihovo.model.offers.Rooms;

import java.util.List;

public interface RoomsService {
    List<Rooms> getAvailableRooms();
    List<Rooms> findAll();
}

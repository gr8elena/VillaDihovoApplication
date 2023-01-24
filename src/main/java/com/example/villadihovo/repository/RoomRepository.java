package com.example.villadihovo.repository;

import com.example.villadihovo.model.offers.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Rooms, Integer> {
    List<Rooms> findAllByAvailabilityTrue();
}

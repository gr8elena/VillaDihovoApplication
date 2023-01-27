package com.example.villadihovo.repository.reservation;

import com.example.villadihovo.model.reservations.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}

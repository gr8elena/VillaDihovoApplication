package com.example.villadihovo.repository;

import com.example.villadihovo.dto.ReservationForEventsDto;
import com.example.villadihovo.model.reservations.ReservationForEventsId;
import com.example.villadihovo.model.reservations.ReservationForEvents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationForEventsRepository extends JpaRepository<ReservationForEvents, ReservationForEventsId> {
    @Query("SELECT new com.example.villadihovo.dto.ReservationForEventsDto(e.event_type, e.price, r.start_date, r.end_date, e.number_of_interested_guests)" +
            "FROM ReservationForEvents rfe " +
            "JOIN Events e ON rfe.event_id = e.event_id " +
            "JOIN Reservation r on rfe.reservation_id = r.reservation_id " +
            "ORDER BY r.start_date")
    List<ReservationForEventsDto> findAllEventReservationsDto();
}

package com.example.villadihovo.repository.reservation;

import com.example.villadihovo.dto.ReservationForActivityDto;
import com.example.villadihovo.model.reservations.ReservationForActivityId;
import com.example.villadihovo.model.reservations.ReservationForActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationForActivityRepository extends JpaRepository<ReservationForActivity, ReservationForActivityId> {
    @Query("SELECT new com.example.villadihovo.dto.ReservationForActivityDto(a.activity_type, a.price, r.start_date, r.end_date, a.number_of_interested_guests, a.activity_location)" +
            "FROM ReservationForActivity rfa " +
            "JOIN Activities a  ON rfa.activity_id = a.activity_id " +
            "JOIN Reservation r ON rfa.reservation_id = r.reservation_id " +
            "ORDER BY r.start_date")
    List<ReservationForActivityDto> findAllActivityReservationsDto();
}

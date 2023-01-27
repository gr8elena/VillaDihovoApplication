package com.example.villadihovo.repository.reservation;

import com.example.villadihovo.dto.ReservationForServiceDto;
import com.example.villadihovo.model.reservations.ReservationForServiceId;
import com.example.villadihovo.model.reservations.ReservationForService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationForServiceRepository extends JpaRepository<ReservationForService, ReservationForServiceId> {
    @Query("SELECT new com.example.villadihovo.dto.ReservationForServiceDto(ut.full_name, s.service_type, s.price, r.start_date, r.end_date)" +
            "FROM ReservationForService rfs " +
            "JOIN Service s ON rfs.service_id = s.service_id " +
            "JOIN Reservation r ON rfs.reservation_id = r.reservation_id " +
            "JOIN UserTable ut ON s.user_id.user_id  = ut.user_id")
    List<ReservationForServiceDto> findAllServiceReservationsDto();
}

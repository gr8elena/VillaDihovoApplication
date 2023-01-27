package com.example.villadihovo.repository.reservation;

import com.example.villadihovo.dto.ReservationForRoomDto;
import com.example.villadihovo.model.reservations.GuestMakeReservationId;
import com.example.villadihovo.model.reservations.GuestsMakeReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestMakeReservationRepository extends JpaRepository<GuestsMakeReservation, GuestMakeReservationId> {
    @Query("SELECT new com.example.villadihovo.dto.ReservationForRoomDto(gmr.reservation_id, r2.room_id, r.start_date , r.end_date, r.number_guests,r.adults,r.children,r2.room_type, r2.price, v.name ,ut.full_name,  ut.phone_number)" +
            " FROM GuestsMakeReservation gmr " +
            "JOIN UserTable ut ON gmr.user_id = ut.user_id " +
            "JOIN Reservation r ON gmr.reservation_id = r.reservation_id " +
            "JOIN Rooms r2 ON r.room_id.room_id = r2.room_id " +
            "JOIN Villa v ON r.villa_id.villa_id = v.villa_id " +
            "ORDER BY r.start_date")
    List<ReservationForRoomDto> findAllRoomReservationsDTO();

    @Query("SELECT new com.example.villadihovo.dto.ReservationForRoomDto(gmr.reservation_id, r2.room_id, r.start_date , r.end_date, r.number_guests,r.adults,r.children,r2.room_type, r2.price, v.name ,ut.full_name,  ut.phone_number)" +
            " FROM GuestsMakeReservation gmr " +
            "JOIN UserTable ut ON gmr.user_id = ut.user_id " +
            "JOIN Reservation r ON gmr.reservation_id = r.reservation_id " +
            "JOIN Rooms r2 ON r.room_id.room_id = r2.room_id " +
            "JOIN Villa v ON r.villa_id.villa_id = v.villa_id " +
            "WHERE r.reservation_id  = gmr.reservation_id AND r.reservation_id = :id")
    ReservationForRoomDto findRoomReservationsDTOById(@Param("id") Integer id);
}

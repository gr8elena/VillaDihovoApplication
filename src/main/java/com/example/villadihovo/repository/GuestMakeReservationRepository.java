package com.example.villadihovo.repository;

import com.example.villadihovo.dto.ReservationForRoomDto;
import com.example.villadihovo.model.GuestMakeReservationId;
import com.example.villadihovo.model.guests_make_reservation;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GuestMakeReservationRepository extends JpaRepository<guests_make_reservation, GuestMakeReservationId> {
    @Query("SELECT new com.example.villadihovo.dto.ReservationForRoomDto(r.start_date , r.end_date, r.number_guests,r.adults,r.children,r2.room_type, r2.price, v.name ,ut.full_name,  ut.phone_number)" +
            " FROM guests_make_reservation gmr " +
            "JOIN user_table ut ON gmr.user_id = ut.user_id " +
            "JOIN reservation r ON gmr.reservation_id = r.reservation_id " +
            "JOIN rooms r2 ON r.room_id.room_id = r2.room_id " +
            "JOIN villa v ON r.villa_id.villa_id = v.villa_id " +
            "ORDER BY r.start_date")
    List<ReservationForRoomDto> findAllRoomReservationsDTO();
}

package com.example.villadihovo.repository;

import com.example.villadihovo.dto.ReservationForFoodDto;
import com.example.villadihovo.model.reservations.ReservationForPreparedMealId;
import com.example.villadihovo.model.reservations.ReservationForPreparedMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReservationForPreparedMealRepository extends JpaRepository<ReservationForPreparedMeal, ReservationForPreparedMealId> {
    @Query(value = "SELECT new com.example.villadihovo.dto.ReservationForFoodDto(ut.full_name, m.meal_type, rfpm.quantity, m.price, r.number_guests, r.start_date)" +
            "FROM ReservationForPreparedMeal rfpm " +
            "JOIN PreparedMeal pm ON  rfpm.prepared_meal_id.prepared_meal_id = pm.prepared_meal_id " +
            "JOIN Meal m on rfpm.meal_id.meal_id = m.meal_id " +
            "JOIN Reservation r on rfpm.reservation_id.reservation_id = r.reservation_id " +
            "JOIN GuestsMakeReservation gmr on r.reservation_id = gmr.reservation_id " +
            "JOIN UserTable ut on gmr.user_id  = ut.user_id " +
            "ORDER BY r.start_date")
    List<ReservationForFoodDto> findAllFoodReservationsDto();
}


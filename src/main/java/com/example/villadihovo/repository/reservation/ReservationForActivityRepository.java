package com.example.villadihovo.repository.reservation;

import com.example.villadihovo.dto.ReservationForActivityDto;
import com.example.villadihovo.model.reservations.ReservationForActivityId;
import com.example.villadihovo.model.reservations.ReservationForActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationForActivityRepository extends JpaRepository<ReservationForActivity, ReservationForActivityId> {

    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Query("SELECT new com.example.villadihovo.dto.ReservationForActivityDto(a.activity_type, a.price, r.start_date, r.end_date, a.number_of_interested_guests, a.activity_location)" +
            "FROM ReservationForActivity rfa " +
            "JOIN Activities a  ON rfa.activity_id = a.activity_id " +
            "JOIN Reservation r ON rfa.reservation_id = r.reservation_id " +
            "ORDER BY r.start_date")
    List<ReservationForActivityDto> findAllActivityReservationsDto();


//    String sql = "SELECT EXTRACT(YEAR FROM start_date) AS years, " +
//            "       COUNT(a.activity_id) AS num_activities, " +
//            "       SUM(a.number_of_interested_guests) AS total_guests, " +
//            "       AVG(a.price) AS avg_price, " +
//            "       SUM(a.price * a.number_of_interested_guests) AS sales " +
//            "FROM reservation_for_activity rfa " +
//            "JOIN reservation r ON rfa.reservation_id = r.reservation_id " +
//            "JOIN activities a ON rfa.activity_id = a.activity_id " +
//            "GROUP BY years";
//    @Query(value = sql , nativeQuery = true)
//    StatisticsForActivityDto findStatistics();


}

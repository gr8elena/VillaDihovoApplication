package com.example.villadihovo.repository;

import com.example.villadihovo.model.reservation;
import com.example.villadihovo.model.user_table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<reservation, Integer> {

}

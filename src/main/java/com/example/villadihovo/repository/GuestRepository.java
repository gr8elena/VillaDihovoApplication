package com.example.villadihovo.repository;

import com.example.villadihovo.model.users.Guests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guests,Integer> {
}

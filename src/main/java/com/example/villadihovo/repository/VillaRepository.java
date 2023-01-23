package com.example.villadihovo.repository;

import com.example.villadihovo.model.user_table;
import com.example.villadihovo.model.villa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VillaRepository extends JpaRepository<villa, Integer> {
}

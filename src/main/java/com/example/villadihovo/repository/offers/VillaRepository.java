package com.example.villadihovo.repository.offers;

import com.example.villadihovo.model.offers.Villa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillaRepository extends JpaRepository<Villa, Integer> {
}

package com.example.villadihovo.repository.statistics;

import com.example.villadihovo.model.statistics.StatisticsForActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsForActivityRepository extends JpaRepository<StatisticsForActivity, Integer> {
}

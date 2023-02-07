package com.example.villadihovo.service.impl.statisticsImpl;


import com.example.villadihovo.model.statistics.StatisticsForActivity;
import com.example.villadihovo.repository.statistics.StatisticsForActivityRepository;
import com.example.villadihovo.service.statistics.StatisticsForActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsForActivityServiceImpl implements StatisticsForActivityService {

    @Autowired
    StatisticsForActivityRepository statistics;

    @Override
    public List<StatisticsForActivity> listAll() {
        return this.statistics.findAll();
    }
}

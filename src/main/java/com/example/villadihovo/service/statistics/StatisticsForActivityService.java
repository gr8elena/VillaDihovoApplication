package com.example.villadihovo.service.statistics;

import com.example.villadihovo.model.statistics.StatisticsForActivity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StatisticsForActivityService {

    List<StatisticsForActivity> listAll();

}

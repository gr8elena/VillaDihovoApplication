package com.example.villadihovo.web.controller.ControllersForAllReservations;

import com.example.villadihovo.dto.ReservationForActivityDto;
import com.example.villadihovo.model.statistics.StatisticsForActivity;
import com.example.villadihovo.service.reservation.ReservationForActivityService;
import com.example.villadihovo.service.statistics.StatisticsForActivityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/reservations/activity")
public class ActivityReservationsController {
    @Autowired
    private ReservationForActivityService reservationForActivityService;
    @Autowired
    private StatisticsForActivityService statistics;

    @GetMapping
    public ModelAndView listAllActivityReservations(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<ReservationForActivityDto> allActivityReservations = this.reservationForActivityService.findAllActivityReservations();
        model.addAttribute("activityReservations", allActivityReservations);
        modelAndView.setViewName("activity-reservations");
        return modelAndView;
    }

    @GetMapping("/statistics")
    public ModelAndView listAllActivitiesAndStatistics(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<ReservationForActivityDto> allActivityReservations = this.reservationForActivityService.findAllActivityReservations();
        List<StatisticsForActivity> statistics = this.statistics.listAll();
        model.addAttribute("activityReservations", allActivityReservations);
        model.addAttribute("statistics", statistics);
        modelAndView.setViewName("activity-statistics");
        return modelAndView;
    }



}

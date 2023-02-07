package com.example.villadihovo.web.controller.ControllersForAllReservations;

import com.example.villadihovo.dto.ReservationForActivityDto;
import com.example.villadihovo.model.statistics.StatisticsForActivity;
import com.example.villadihovo.service.reservation.ReservationForActivityService;
import com.example.villadihovo.service.statistics.StatisticsForActivityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/reservations/activity")
public class ActivityReservationsController {
    @Autowired
    private ReservationForActivityService reservationForActivityService;
    @Autowired
    private StatisticsForActivityService statistics;

    @GetMapping
    public String listAllActivityReservations(Model model){
        List<ReservationForActivityDto> allActivityReservations = this.reservationForActivityService.findAllActivityReservations();
        model.addAttribute("activityReservations", allActivityReservations);
        return "activity-reservations";
    }

    @GetMapping("/statistics")
    public String listAllActivitiesAndStatistics(Model model){
        List<ReservationForActivityDto> allActivityReservations = this.reservationForActivityService.findAllActivityReservations();
        List<StatisticsForActivity> statistics = this.statistics.listAll();
        model.addAttribute("activityReservations", allActivityReservations);
        model.addAttribute("statistics", statistics);
        return "activity-statistics";
    }



}

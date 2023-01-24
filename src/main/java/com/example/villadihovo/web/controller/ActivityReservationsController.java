package com.example.villadihovo.web.controller;

import com.example.villadihovo.dto.ReservationForActivityDto;
import com.example.villadihovo.service.ReservationForActivityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/activity/reservations")
public class ActivityReservationsController {

    @Autowired
    private ReservationForActivityService reservationForActivityService;

    @GetMapping
    public ModelAndView listAllRoomReservations(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<ReservationForActivityDto> allActivityReservations = this.reservationForActivityService.findAllActivityReservations();
        model.addAttribute("activityReservations", allActivityReservations);
        modelAndView.setViewName("activity-reservations");
        return modelAndView;
    }
}

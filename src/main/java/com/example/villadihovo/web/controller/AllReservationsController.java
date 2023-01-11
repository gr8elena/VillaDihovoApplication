package com.example.villadihovo.web.controller;

import com.example.villadihovo.model.reservation;
import com.example.villadihovo.service.ReservationService;
import com.example.villadihovo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/allReservations")
public class AllReservationsController {

    ReservationService reservationService;
//    @GetMapping
//    public ModelAndView getReservationsPage() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("allReservations");
//        return modelAndView;
//    }

    @GetMapping
    public ModelAndView listAllReservations(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<reservation> allReservations = this.reservationService.allReservations();
       model.addAttribute("reservations", allReservations);
        modelAndView.setViewName("allReservations");
        return modelAndView;
    }
}

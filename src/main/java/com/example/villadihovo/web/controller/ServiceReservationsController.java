package com.example.villadihovo.web.controller;

import com.example.villadihovo.dto.ReservationForRoomDto;
import com.example.villadihovo.dto.ReservationForServiceDto;
import com.example.villadihovo.service.GuestMakeReservationService;
import com.example.villadihovo.service.ReservationForServiceService;
import com.example.villadihovo.service.VillaService;
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
@RequestMapping("/serviceReservations")
public class ServiceReservationsController {
    @Autowired
    private ReservationForServiceService reservationForServiceService;

    @GetMapping
    public ModelAndView listAllRoomReservations(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<ReservationForServiceDto> allServiceReservations = this.reservationForServiceService.findAllServiceReservations();
        model.addAttribute("serviceReservations", allServiceReservations);
        modelAndView.setViewName("serviceReservations");
        return modelAndView;
    }
}

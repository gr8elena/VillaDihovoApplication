package com.example.villadihovo.web.controller.ControllersForAllReservations;

import com.example.villadihovo.dto.ReservationForServiceDto;
import com.example.villadihovo.service.reservation.ReservationForServiceService;
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
@RequestMapping("/reservations/service")
public class ServiceReservationsController {
    @Autowired
    private ReservationForServiceService reservationForServiceService;

    @GetMapping
    public ModelAndView listAllRoomReservations(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<ReservationForServiceDto> allServiceReservations = this.reservationForServiceService.findAllServiceReservations();
        model.addAttribute("serviceReservations", allServiceReservations);
        modelAndView.setViewName("service-reservations");
        return modelAndView;
    }
}

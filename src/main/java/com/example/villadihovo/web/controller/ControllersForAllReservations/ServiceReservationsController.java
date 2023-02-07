package com.example.villadihovo.web.controller.ControllersForAllReservations;

import com.example.villadihovo.dto.ReservationForServiceDto;
import com.example.villadihovo.service.reservation.ReservationForServiceService;
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
@AllArgsConstructor
@RequestMapping("/reservations/service")
public class ServiceReservationsController {
    @Autowired
    private ReservationForServiceService reservationForServiceService;

    @GetMapping
    public String listAllRoomReservations(Model model){
        List<ReservationForServiceDto> allServiceReservations = this.reservationForServiceService.findAllServiceReservations();
        model.addAttribute("serviceReservations", allServiceReservations);
        return "service-reservations";
    }
}

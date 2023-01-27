package com.example.villadihovo.web.controller.ControllersForAllReservations;

import com.example.villadihovo.dto.ReservationForEventsDto;
import com.example.villadihovo.service.reservation.ReservationForEventsService;
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
@RequestMapping("/reservations/event")
public class EventReservationsController {

    @Autowired
    private ReservationForEventsService reservationForEventsService;

    @GetMapping
    public ModelAndView listAllRoomReservations(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<ReservationForEventsDto> allEventReservations = this.reservationForEventsService.findAllEventReservations();
        model.addAttribute("eventReservations", allEventReservations);
        modelAndView.setViewName("event-reservations");
        return modelAndView;
    }
}

package com.example.villadihovo.web.controller;

import com.example.villadihovo.dto.ReservationForRoomDto;
import com.example.villadihovo.model.offers.Rooms;
import com.example.villadihovo.model.offers.Villa;
import com.example.villadihovo.service.GuestMakeReservationService;
import com.example.villadihovo.service.RoomsService;
import com.example.villadihovo.service.VillaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.h2.engine.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservations/rooms")
public class RoomReservationsController {

    @Autowired
    GuestMakeReservationService guestMakeReservationService;
    @Autowired
    VillaService villaService;
    @Autowired
    RoomsService roomsService;

    @GetMapping
    public ModelAndView listAllRoomReservations(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<ReservationForRoomDto> allRoomReservations = this.guestMakeReservationService.findAllRoomReservations();
       model.addAttribute("roomReservations", allRoomReservations);
        modelAndView.setViewName("room-reservations");
        return modelAndView;
    }
    @GetMapping("/edit-form/{id}")
    public ModelAndView getEditPage(@PathVariable(required = false) Integer id, Model model) {
        List<Villa> villaList = villaService.listAllVillas();
        ReservationForRoomDto roomDto = guestMakeReservationService.findRoomReservationByReservationId(id);
        List<Rooms> availableRooms = roomsService.findAll();
        model.addAttribute("villas", villaList);
        model.addAttribute("roomDto", roomDto);
        model.addAttribute("available_rooms", availableRooms);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit-form-rooms");
        return modelAndView;
    }
    @PostMapping(value = "/update")
    public ModelAndView updateReservation(@RequestParam("reservation_id") Integer reservation_id,
                                          @RequestParam("start_date") LocalDate start_date,
                                          @RequestParam("end_date") LocalDate end_date,
                                          @RequestParam("adults") Integer adults,
                                          @RequestParam("children") Integer children,
                                          @RequestParam("number_guests") Integer number_guests,
                                          Model model){
        ReservationForRoomDto updatedRoom = guestMakeReservationService.updateRoomReservationById(reservation_id,start_date,end_date,adults,children,number_guests);
        model.addAttribute("roomDto", updatedRoom);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/reservations/rooms");
        return modelAndView;
    }

    @DeleteMapping(value = "/delete/{id}")
    public ModelAndView deleteReservation(@PathVariable Integer id){
        guestMakeReservationService.deleteReservationById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/reservations/rooms");
        return modelAndView;
    }

}

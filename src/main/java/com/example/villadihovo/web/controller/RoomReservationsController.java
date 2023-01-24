package com.example.villadihovo.web.controller;

import com.example.villadihovo.dto.ReservationForRoomDto;
import com.example.villadihovo.model.offers.Rooms;
import com.example.villadihovo.model.offers.Villa;
import com.example.villadihovo.service.GuestMakeReservationService;
import com.example.villadihovo.service.RoomsService;
import com.example.villadihovo.service.VillaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/roomReservations")
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
        modelAndView.setViewName("allReservations");
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
    @PutMapping("/edit-form/{id}")
    public ModelAndView updateReservation(@PathVariable("id") Integer reservation_id,
                                          @RequestBody ReservationForRoomDto roomDto, Model model){
        ReservationForRoomDto updatedRoom = guestMakeReservationService.updateRoomReservationById(reservation_id, roomDto);
        model.addAttribute("roomDto", updatedRoom);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit-form-rooms");
        return modelAndView;
    }

}

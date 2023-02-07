package com.example.villadihovo.web.controller.ControllersForAllReservations;

import com.example.villadihovo.dto.ReservationForRoomDto;
import com.example.villadihovo.model.offers.Rooms;
import com.example.villadihovo.model.offers.Villa;
import com.example.villadihovo.service.reservation.GuestMakeReservationService;
import com.example.villadihovo.service.offers.RoomsService;
import com.example.villadihovo.service.offers.VillaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
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
    public String listAllRoomReservations(Model model){
        List<ReservationForRoomDto> allRoomReservations = this.guestMakeReservationService.findAllRoomReservations();
       model.addAttribute("roomReservations", allRoomReservations);
        return "room-reservations";
    }
    @GetMapping("/edit-form/{id}")
    public String getEditPage(@PathVariable(required = false) Integer id, Model model) {
        List<Villa> villaList = villaService.listAllVillas();
        ReservationForRoomDto roomDto = guestMakeReservationService.findRoomReservationByReservationId(id);
        List<Rooms> availableRooms = roomsService.findAll();
        model.addAttribute("villas", villaList);
        model.addAttribute("roomDto", roomDto);
        model.addAttribute("available_rooms", availableRooms);
        return "edit-form-rooms";
    }
    @PostMapping(value = "/update")
    public String updateReservation(@RequestParam("reservation_id") Integer reservation_id,
                                          @RequestParam("start_date") LocalDate start_date,
                                          @RequestParam("end_date") LocalDate end_date,
                                          @RequestParam("adults") Integer adults,
                                          @RequestParam("children") Integer children,
                                          @RequestParam("number_guests") Integer number_guests,
                                          Model model){
        ReservationForRoomDto updatedRoom = guestMakeReservationService.updateRoomReservationById(reservation_id,start_date,end_date,adults,children,number_guests);
        model.addAttribute("roomDto", updatedRoom);
        return "redirect:/reservations/rooms";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteReservation(@PathVariable Integer id){
        guestMakeReservationService.deleteReservationById(id);
        return "redirect:/reservations/rooms";
    }

}

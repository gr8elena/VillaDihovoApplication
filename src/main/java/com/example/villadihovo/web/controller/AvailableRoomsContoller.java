package com.example.villadihovo.web.controller;

import com.example.villadihovo.model.offers.Rooms;
import com.example.villadihovo.service.RoomsService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/rooms/available")
public class AvailableRoomsContoller {

    private RoomsService roomsService;

    @GetMapping
    public ModelAndView listAllAvailableRooms(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<Rooms> availableRooms = this.roomsService.getAvailableRooms();
        model.addAttribute("availableRooms",  availableRooms);
        modelAndView.setViewName("available-rooms");
        return modelAndView;
    }

    @GetMapping("/reserve/{id}")
    public ModelAndView getReservePage(@PathVariable(required = false) Integer id, Model model){
        ModelAndView modelAndView = new ModelAndView();
        Optional<Rooms> chosenRoom = roomsService.findRoomById(id);
        model.addAttribute("roomChosen", chosenRoom);
        modelAndView.setViewName("reservation-form-rooms");
        return modelAndView;
    }
}

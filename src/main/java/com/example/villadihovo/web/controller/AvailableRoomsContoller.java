package com.example.villadihovo.web.controller;

import com.example.villadihovo.dto.ReservationForRoomDto;
import com.example.villadihovo.model.offers.Rooms;
import com.example.villadihovo.service.RoomsService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
}

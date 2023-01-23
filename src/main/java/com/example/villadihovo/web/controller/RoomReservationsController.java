package com.example.villadihovo.web.controller;

import com.example.villadihovo.dto.ReservationForRoomDto;
import com.example.villadihovo.model.villa;
import com.example.villadihovo.service.GuestMakeReservationService;
import com.example.villadihovo.service.VillaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/roomReservations")
public class RoomReservationsController {

    @Autowired
    GuestMakeReservationService guestMakeReservationService;
    VillaService villaService;

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
        villa villaForEdit = this.villaService.getById(id);
        List<villa> villaList;
        villaList = villaService.listAllVillas();
        model.addAttribute("edit-villa", villaForEdit);
        model.addAttribute("villas", villaList);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit-form-rooms");
        return modelAndView;
    }
}

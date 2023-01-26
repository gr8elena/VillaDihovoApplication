package com.example.villadihovo.web.controller;

import com.example.villadihovo.dto.ReservationForEventsDto;
import com.example.villadihovo.dto.ServiceForBeveragesDto;
import com.example.villadihovo.service.ServiceForBeveragesService;
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
@RequestMapping("/reservations/beverage")
public class BeverageReservationsController {

    @Autowired
    private ServiceForBeveragesService serviceForBeveragesService;

    @GetMapping
    public ModelAndView listAllBeverageReservations(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<ServiceForBeveragesDto> allBeverageReservations = this.serviceForBeveragesService.findAllServiceForBeverages();
        model.addAttribute("beverageReservations", allBeverageReservations);
        modelAndView.setViewName("beverage-reservations");
        return modelAndView;
    }

}

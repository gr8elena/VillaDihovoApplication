package com.example.villadihovo.web.controller;

import com.example.villadihovo.dto.ReservationForFoodDto;
import com.example.villadihovo.dto.ReservationForRoomDto;
import com.example.villadihovo.service.ReservationForPreparedMealService;
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
@RequestMapping("/foodReservations")
public class FoodReservationsController {

    @Autowired
    private ReservationForPreparedMealService reservationForPreparedMealService;

    @GetMapping
    public ModelAndView listAllPreparedMealReservations(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<ReservationForFoodDto> allFoodReservations = this.reservationForPreparedMealService.findAllFoodReservations();
        model.addAttribute("foodReservations", allFoodReservations);
        modelAndView.setViewName("foodReservations");
        return modelAndView;
    }
}

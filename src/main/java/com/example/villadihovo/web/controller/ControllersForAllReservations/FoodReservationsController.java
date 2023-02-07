package com.example.villadihovo.web.controller.ControllersForAllReservations;

import com.example.villadihovo.dto.ReservationForFoodDto;
import com.example.villadihovo.service.reservation.ReservationForPreparedMealService;
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
@RequestMapping("/reservations/food")
public class FoodReservationsController {

    @Autowired
    private ReservationForPreparedMealService reservationForPreparedMealService;

    @GetMapping
    public ModelAndView listAllPreparedMealReservations(Model model){
        ModelAndView modelAndView = new ModelAndView();
        List<ReservationForFoodDto> allFoodReservations = this.reservationForPreparedMealService.findAllFoodReservations();
        model.addAttribute("foodReservations", allFoodReservations);
        modelAndView.setViewName("food-reservations");
        return modelAndView;
    }
}
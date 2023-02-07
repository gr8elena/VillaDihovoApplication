package com.example.villadihovo.web.controller.ControllersForAllReservations;

import com.example.villadihovo.dto.ReservationForFoodDto;
import com.example.villadihovo.service.reservation.ReservationForPreparedMealService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/reservations/food")
public class FoodReservationsController {

    @Autowired
    private ReservationForPreparedMealService reservationForPreparedMealService;

    @GetMapping
    public String listAllPreparedMealReservations(Model model){
        List<ReservationForFoodDto> allFoodReservations = this.reservationForPreparedMealService.findAllFoodReservations();
        model.addAttribute("foodReservations", allFoodReservations);
        return "food-reservations";
    }
}

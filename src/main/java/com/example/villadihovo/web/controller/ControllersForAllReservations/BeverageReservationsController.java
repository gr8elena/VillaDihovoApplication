package com.example.villadihovo.web.controller.ControllersForAllReservations;

import com.example.villadihovo.dto.ServiceForBeveragesDto;
import com.example.villadihovo.service.reservation.ServiceForBeveragesService;
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
@RequestMapping("/reservations/beverage")
public class BeverageReservationsController {

    @Autowired
    private ServiceForBeveragesService serviceForBeveragesService;

    @GetMapping
    public String listAllBeverageReservations(Model model){
        List<ServiceForBeveragesDto> allBeverageReservations = this.serviceForBeveragesService.findAllServiceForBeverages();
        model.addAttribute("beverageReservations", allBeverageReservations);
        return "beverage-reservations";
    }

}

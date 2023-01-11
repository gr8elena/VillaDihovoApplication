package com.example.villadihovo.web.controller;

import com.example.villadihovo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@AllArgsConstructor
@RequestMapping("/allReservations")
public class AllReservationsController {

    UserService userService;
    @GetMapping
    public ModelAndView getReservationsPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allReservations");
        return modelAndView;
    }
}

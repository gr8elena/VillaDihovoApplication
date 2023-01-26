package com.example.villadihovo.web.controller;

import com.example.villadihovo.exceptions.InvalidArgumentException;
import com.example.villadihovo.exceptions.PasswordDoNotMatchException;
import com.example.villadihovo.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("/api/register")
public class RegisterController {

    @Autowired
    private AuthService authService;

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if(error != null && !error.isEmpty()){
            model.addAttribute("hasError", true);
            model.addAttribute("hasError", error);
        }
        return "registration";
    }
    @PostMapping
    public  String register(@RequestParam String embg,
                            @RequestParam String address,
                            @RequestParam String email,
                            @RequestParam String username,
                            @RequestParam String password,
                            @RequestParam String repeatPassword,
                            @RequestParam String full_name,
                            @RequestParam String phone_number){
        try{
            this.authService.register(embg,address,email,username,password,repeatPassword,full_name,phone_number);
            return "redirect:/api/login";
        }
        catch(PasswordDoNotMatchException | InvalidArgumentException exception){
            return "redirect:/api/redister?error=" + exception.getMessage();
        }

    }
}

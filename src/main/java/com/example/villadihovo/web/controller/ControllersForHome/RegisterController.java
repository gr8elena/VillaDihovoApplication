package com.example.villadihovo.web.controller.ControllersForHome;

import com.example.villadihovo.exceptions.InvalidArgumentException;
import com.example.villadihovo.exceptions.PasswordDoNotMatchException;
import com.example.villadihovo.service.login.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
                            @RequestParam String phone_number,
                            Model model){
        try{
            this.authService.register(embg,address,email,username,password,repeatPassword,full_name,phone_number);
            return "redirect:/api/login";
        }
        catch(PasswordDoNotMatchException | InvalidArgumentException exception){
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
//            return "redirect:/api/register?error=" + exception.getMessage();
            return "registration";
        }

    }
}

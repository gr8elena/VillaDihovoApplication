package com.example.villadihovo.web.controller;

import com.example.villadihovo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@AllArgsConstructor
@RequestMapping("/api/login")
public class LoginController {

    UserService userService;
    @GetMapping
    public ModelAndView getLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

//    @PostMapping
//    public String getLoginPage(@RequestParam String username,
//                               @RequestParam String password,
//                               HttpServletRequest request){
//
//        if(this.userService.findByUsernameAndPassword(username,password).isPresent()) {
//            return "redirect:/api/login";
//        }
//        return "redirect:/login";
//    }
}

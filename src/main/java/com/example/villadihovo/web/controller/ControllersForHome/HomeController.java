package com.example.villadihovo.web.controller.ControllersForHome;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public String getHomePage(HttpSession session,Model model) {
        String role;
        if(session.getAttribute("role") == null){
            role = "default";
            session.setAttribute("role",role);
            return "home";
        }
        return "home";
    }
    @GetMapping("/contact")
    public String getContactPage(){
        return "contact";
    }
}

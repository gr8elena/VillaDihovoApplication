package com.example.villadihovo.web.controller.ControllersForHome;

import com.example.villadihovo.exceptions.InvalidArgumentException;
import com.example.villadihovo.exceptions.InvalidUserCredentialsException;
import com.example.villadihovo.model.attempts.LogIn;
import com.example.villadihovo.model.users.UserTable;
import com.example.villadihovo.repository.attempts.LoginRepository;
import com.example.villadihovo.service.login.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalTime;

@RestController
@AllArgsConstructor
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private AuthService authService;
    @Autowired
    private LoginRepository loginRepository;

    @GetMapping
    public ModelAndView getLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView login(@RequestParam String username, @RequestParam String password, HttpServletRequest request, Model model){
        UserTable user = null;
        String role;
        try{
                user = this.authService.login(username,password);
                request.getSession().setAttribute("user", user);
                if(user.getUser_id() > 14)
                {
                    role = "user";
                }else
                {
                    role = "employee";
                }
                request.getSession().setAttribute("role", role);
                LogIn login = new LogIn(LocalTime.now().toString(), user);
                this.loginRepository.save(login);
                return new ModelAndView( "redirect:/home");

        }catch(InvalidUserCredentialsException | InvalidArgumentException exception){
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return new ModelAndView( "login.html");
        }
    }
}

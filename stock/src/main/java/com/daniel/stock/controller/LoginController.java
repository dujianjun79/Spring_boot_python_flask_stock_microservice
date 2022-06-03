package com.daniel.stock.controller;

import com.daniel.stock.model.LoginForm;
import com.daniel.stock.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLoginForm(){
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, Model model){
        String username = user.getUsername();
        String password = user.getPassword();

        if("admin".equals(username) && "admin".equals(password)){
            return "redirect:/home.html";
        }
        else{
            model.addAttribute("msg","user name or password error");
            return "login";
        }


    }

    @GetMapping("/home.html")
    public String homePage(){
        return "home";
    }

}

package com.daniel.stock.controller;

import com.daniel.stock.model.User;
import com.daniel.stock.service.AddUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    private final AddUser addUser;

    public SignupController(AddUser addUser) {
        this.addUser = addUser;
    }

    @GetMapping("/signup")
    public String SignupPage(){
        return "signup";
    }

    @PostMapping("/signup")
    public String Signup(User user){

        addUser.signUpUser(user);

        return "redirect:/home.html";

    }


}

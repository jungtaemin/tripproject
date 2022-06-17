package com.tripproject.user.adapter.in;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class UserController {



    @GetMapping("/login")
    public String login(){
        return "index";
    }
}

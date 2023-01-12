package com.example.springmarket.controller2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("auth/admin")
    public String getAdminPage(){
        return "adminPage";
    }
}
package com.example.springmarket.controller2;


import com.example.springmarket.model.MovieSession;
import com.example.springmarket.service.MovieSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/movieSession")
public class MovieSessionController {
    @Autowired
    private MovieSessionService movieSessionService;

    @GetMapping("/list")
    public String getList(Model model)  {

        List<MovieSession> movieSessionList = movieSessionService.getAll();
        model.addAttribute("movieSessionList", movieSessionList);
        return "index";

    }
}

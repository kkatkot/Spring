package com.example.springmarket.controller2;


import com.example.springmarket.model.Place;
import com.example.springmarket.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;


    @GetMapping("/{movieSessionId}")
    public String  getPlacesOFOneSession(@PathVariable(name = "movieSessionId") int sessionId, Model model) {

        List<Place> places = placeService.getAllByMovieSessionId(sessionId);
        model.addAttribute("places", places);
        model.addAttribute("sessionId", sessionId);
        return "places";
    }
}

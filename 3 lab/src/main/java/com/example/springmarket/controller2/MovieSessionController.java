package com.example.springmarket.controller2;


import com.example.springmarket.model.MovieSession;
import com.example.springmarket.service.MovieSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
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

    //+
    @GetMapping("/create")
    public String createMovieSession(){

        return "AddMovieSessionForm";
    }


    @PostMapping("/create")
    public String createMovieSession(@RequestParam("id") int id,
                                     @RequestParam("startOfSession") String startOfSession,
                                     @RequestParam("duration") int duration, @RequestParam("description") String description,
                                     @RequestParam("imgUrl") String imageUrl)
    {
        MovieSession movieSession = new MovieSession(id, duration, Timestamp.valueOf(startOfSession), description, imageUrl);
        movieSessionService.save(movieSession);
        return "redirect:/movieSession/admin/list";
    }


    @GetMapping("/update/{movieSessionId}")
    public String updateMovieSession(@PathVariable("movieSessionId") int movieSessionId, Model model){
        if(!movieSessionService.findById(movieSessionId)){
            return "Category does not exist";
        }
        MovieSession movieSession = movieSessionService.getById(movieSessionId);
        model.addAttribute("movieSession", movieSession);
        return "UpdateMovieSessionForm";
    }
//
    @PostMapping("/update/{movieSessionId}")
    public String updateMovieSession(@RequestParam("id") int id,
            @RequestParam("startOfSession") String startOfSession,
                                     @RequestParam("duration") int duration, @RequestParam("description") String description,
                                     @RequestParam("imgUrl") String imageUrl){
        System.out.println(description);
        MovieSession movieSession = new MovieSession(id, duration, Timestamp.valueOf(startOfSession), description, imageUrl);
        movieSessionService.update(movieSession);
        return "redirect:/movieSession/admin/list";
    }

    @GetMapping("admin/list")
    public String getAdminList(Model model) {
        List<MovieSession> movieSessionList = movieSessionService.getAll();
        model.addAttribute("movieSessionList", movieSessionList);
        return "adminMovieSession";

    }

    @PostMapping("delete/{id}")
    public String deleteCategory(@PathVariable("id") int id){
        movieSessionService.deleteById(id);
        return "redirect:/movieSession/admin/list";
    }
}

package com.example.springmarket.restController;


import com.example.springmarket.model.MovieSession;
import com.example.springmarket.response.ApiResponse;
import com.example.springmarket.service.MovieSessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieSession")
@Api(value = "Controller for movie session")
public class MovieSessionController {

    @Autowired
    private MovieSessionService movieSessionService;




    @PostMapping("/")
    @ApiOperation(value = "create movie session")
    public ResponseEntity<ApiResponse> createMovieSession(@RequestBody MovieSession movieSession) {
        movieSessionService.save(movieSession);
        return new ResponseEntity<>(new ApiResponse(true, "a new movie session created"), HttpStatus.CREATED);
    }

    @GetMapping("/")
    @ApiOperation(value = "get all movie sessions")
    public ResponseEntity<List<MovieSession>> listMovieSession() {

        List<MovieSession> movieSessions =  movieSessionService.getAll();
        return new ResponseEntity<>(movieSessions, HttpStatus.OK);
    }


    @PatchMapping("/{movieSessionId}")
    @ApiOperation(value = "update movie session")
    public ResponseEntity<ApiResponse> updateMovieSession(@PathVariable("movieSessionId") int movieSessionId, @RequestBody MovieSession movieSession) {

        if (!movieSessionService.findById(movieSessionId)) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "movie Session does not exists"), HttpStatus.NOT_FOUND);
        }
        movieSessionService.update(movieSession);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "movie Session has been updated"), HttpStatus.OK);
    }


    @DeleteMapping("/{movieSessionId}")
    @ApiOperation(value = "delete movie session by id")
    public ResponseEntity<ApiResponse> deleteMovieSession(@PathVariable("movieSessionId") int movieSessionId) {
        if(!movieSessionService.findById(movieSessionId))
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "movie Session does not exists"), HttpStatus.NOT_FOUND);
        movieSessionService.deleteById(movieSessionId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "movie Session has been deleted"), HttpStatus.OK);

    }

}

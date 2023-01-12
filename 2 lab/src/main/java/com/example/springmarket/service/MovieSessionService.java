package com.example.springmarket.service;

import com.example.springmarket.model.MovieSession;
import com.example.springmarket.repository.MovieSessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class MovieSessionService {

    @Autowired
    private MovieSessionRepository movieSessionRepository;


    public List<MovieSession> getAll(){return movieSessionRepository.getAll();}
    public MovieSession getById(int id){
        return movieSessionRepository.findById(id);
    }

    public void save(MovieSession movieSession){
        movieSessionRepository.add(movieSession);
    }
    public void deleteById(int id){
        movieSessionRepository.deleteById(id);
    }

    public boolean findById(int id){
        return movieSessionRepository.exist(id);
    }

}

package com.example.springmarket.service;


import com.example.springmarket.model.Place;
import com.example.springmarket.repository.PlaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlaceService {

    @Autowired
    PlaceRepository placeRepository;

    public List<Place> getAll(){return placeRepository.getAll();}
    public Place getById(int id){
        return placeRepository.findById(id);
    }

    public void save(Place place){
        placeRepository.add(place);
    }
    public void deleteById(int id){
        placeRepository.deleteById(id);
    }

    public boolean findById(int id){
        return placeRepository.exist(id);
    }

    public List<Place> getAllByMovieSessionId(int movieSessionId) {
        return placeRepository.getAllByMovieSessionId(movieSessionId);
    }
}

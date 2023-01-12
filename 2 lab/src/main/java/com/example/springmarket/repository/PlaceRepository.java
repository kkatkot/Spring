package com.example.springmarket.repository;

import com.example.springmarket.model.Place;

import java.util.List;

public interface PlaceRepository {
    public Place findById(int id);
    public List<Place> getAll();
    public void add(Place place);
    public void deleteById(int id);
    public void update(Place place);
    public boolean exist(int id);

    List<Place> getAllByMovieSessionId(int movieSessionId);
}

package com.example.springmarket.repository;

import com.example.springmarket.model.MovieSession;

import java.util.List;

public interface MovieSessionRepository {

    public MovieSession findById(int id);
    public List<MovieSession> getAll();
    public void add(MovieSession movieSession);
    public void deleteById(int id);
    public void update(MovieSession movieSession);
    public boolean exist(int id);
}

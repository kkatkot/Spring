package com.example.springmarket.repository;

import com.example.springmarket.model.MovieSession;
import com.example.springmarket.model.Place;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class FakePlaceRepo implements PlaceRepository {

    private List<Place> places;

    public FakePlaceRepo() {
        this.places = create();
    }

    private List<Place> create(){

        List<Place> places = new ArrayList<>();
        MovieSession movieSession = new MovieSession();
        movieSession.setId(1);
        MovieSession movieSession2 = new MovieSession();
        movieSession2.setId(2);
        places.add(new Place(1, 350, 12, 7, movieSession));
        places.add(new Place(2, 300, 5, 14, movieSession));
        places.add(new Place(3, 300, 5, 13, movieSession));


        places.add(new Place(4, 200, 6, 9, movieSession2));
        places.add(new Place(5, 200, 4, 11, movieSession2));
        places.add(new Place(6, 200, 1, 2, movieSession2));
        return places;
    }

    @Override
    public Place findById(int id) {
        Optional<Place> optionalPlace = places.stream().filter(x -> x.getId() == id).findFirst();
        if(optionalPlace.isPresent())
            return optionalPlace.get();
        return null;
    }

    @Override
    public List<Place> getAll() {
        return places;
    }

    @Override
    public void add(Place place) {
        places.add(place);
    }

    @Override
    public void deleteById(int id) {
        places.removeIf(x -> x.getId() == id);
    }

    @Override
    public void update(Place place) {
        Place place1 = null;
        for (Place place2: places) {
            if(place.getId() == place2.getId()){
                place1 = place2;
                break;
            }
        }

        if(place1 == null){
            places.add(place);
            return;
        }

        place1.setPlace(place.getPlace());
        place1.setPrice(place.getPrice());
        place1.setMovieSession(place.getMovieSession());
        place1.setRow(place.getRow());
    }

    @Override
    public boolean exist(int id) {
        return findById(id) != null;
    }

    @Override
    public List<Place> getAllByMovieSessionId(int movieSessionId) {
        return places.stream().
                filter(x -> x.getMovieSession().getId() == movieSessionId).
                collect(Collectors.toList());
    }
}

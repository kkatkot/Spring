package com.example.springmarket.repository;

import com.example.springmarket.model.MovieSession;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class FakeMovieSessionRepo implements MovieSessionRepository{

    private List<MovieSession> movieSessions;


    public FakeMovieSessionRepo() {
        this.movieSessions = create();
    }


    private List<MovieSession> create()
    {
        List<MovieSession> movieSessions = new ArrayList<>();
        movieSessions.add(new MovieSession(1, 210, "2018-09-01 08:01:15", "AVATAR", "https://image.cnbcfm.com/api/v1/image/105897632-1557241558937avatar-e1541360922907.jpg?v=1664130328&w=1920&h=1080" ));
        movieSessions.add(new MovieSession(2, 210, "2019-09-01 09:01:15", "Форсаж", "https://whatisgood.ru/wp-content/uploads/2021/06/o-filme-forsazh-9-1.jpg" ));
        movieSessions.add(new MovieSession(3, 210, "2022-09-01 07:01:15", "Початок", "https://prm.ua/wp-content/uploads/2018/08/150417_pochatok.jpg" ));

        return movieSessions;
    }

    @Override
    public MovieSession findById(int id) {
        Optional<MovieSession> movieSessionOptional = movieSessions.stream().filter(x -> x.getId() == id).findFirst();
        if(movieSessionOptional.isPresent())
            return movieSessionOptional.get();
        return null;
    }

    @Override
    public List<MovieSession> getAll() {
        return movieSessions;
    }

    @Override
    public void add(MovieSession movieSession) {
        movieSessions.add(movieSession);
    }

    @Override
    public void deleteById(int id) {
        movieSessions.removeIf(x -> x.getId() == id);
    }

    @Override
    public void update(MovieSession movieSession) {
        MovieSession movieSession1 = null;

        for (MovieSession movieSession2 : movieSessions) {
            if(movieSession2.getId() == movieSession.getId()){
                movieSession1 = movieSession2;
                break;
            }
        }

        if(movieSession1 == null)
        {
            movieSessions.add(movieSession);
            return;
        }

        movieSession1.setStartOfSession(movieSession.getStartOfSession());
        movieSession1.setDuration(movieSession.getDuration());
        movieSession1.setImgUrl(movieSession.getImgUrl());
        movieSession1.setDescription(movieSession.getDescription());
    }

    @Override
    public boolean exist(int id) {
         return findById(id) != null;
    }
}

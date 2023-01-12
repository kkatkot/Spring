package com.example.springmarket.model;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Place
{
    private int id;
    private int price;
    private int row;
    private int place;
    private  MovieSession movieSession;

    public Place(int price, int row, int place, MovieSession movieSession) {
        this.price = price;
        this.row = row;
        this.place = place;
        this.movieSession = movieSession;
    }
}

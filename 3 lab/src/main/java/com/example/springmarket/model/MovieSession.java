package com.example.springmarket.model;


import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class MovieSession {

    private int id;
    private int duration; // in minutes
    private Timestamp startOfSession;
    private String description;
    private String imgUrl;

    public MovieSession(int duration, Timestamp startOfSession, String description, String imgUrl) {
        this.duration = duration;
        this.startOfSession = startOfSession;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    //    String str="2018-09-01 09:01:15";
//    Timestamp timestamp= Timestamp.valueOf(str);
}

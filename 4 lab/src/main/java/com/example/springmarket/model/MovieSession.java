package com.example.springmarket.model;


import io.swagger.annotations.ApiModel;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@ApiModel(value = "class for movie session")
public class MovieSession {

    private int id;
    private int duration; // in minutes
    private String startOfSession;
    private String description;
    private String imgUrl;

    public MovieSession(int duration, String startOfSession, String description, String imgUrl) {
        this.duration = duration;
        this.startOfSession = startOfSession;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    //    String str="2018-09-01 09:01:15";
//    Timestamp timestamp= Timestamp.valueOf(str);
}

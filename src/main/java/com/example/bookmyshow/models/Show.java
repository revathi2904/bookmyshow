package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "shows")

public class Show extends  BaseModel{

    @ManyToOne
    private Movie movie;
    private String language;
    private String startTime;
    private String endTime;
    @ManyToOne
    private Screen screen;


}

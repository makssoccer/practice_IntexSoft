package com.example.opinion_about_the_players.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Club {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name_club;

    public String getName_club() {
        return name_club;
    }

    public void setName_club(String name_club) {
        this.name_club = name_club;
    }

    public Long getId_Club() {
        return id;
    }

    public void setId_Club(Long id) {
        this.id = id;
    }

}
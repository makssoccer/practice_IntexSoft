package com.example.opinion_about_the_players.models;

import javax.persistence.*;

@Entity
public class Player {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Short age;

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    private String name_player, anons, full_text;
//    private int views;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")




    public String getName_player() {
        return name_player;
    }

    public void setName_player(String name_player) {
        this.name_player = name_player;
    }


    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    /*public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }*/

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player() {
    }
    public Player(String name_player, String anons, String full_text) {
        this.name_player = name_player;
        this.anons = anons;
        this.full_text = full_text;

    }
}

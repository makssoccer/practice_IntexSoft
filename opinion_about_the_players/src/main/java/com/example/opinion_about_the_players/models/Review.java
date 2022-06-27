package com.example.opinion_about_the_players.models;

import javax.persistence.*;

@Entity
@Table(name="review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    ////connection with player
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Player player;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User usr;

    ////connection with club



    @Column(name = "anons")
    private String anons;

    @Column(name = "fullRewiew")
    private String fullRewiew;

    public User getUser() {
        return usr;
    }

    public void setUser(User user) {
        this.usr = user;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getFullRewiew() {
        return fullRewiew;
    }

    public void setFullRewiew(String fullRewiew) {
        this.fullRewiew = fullRewiew;
    }
}

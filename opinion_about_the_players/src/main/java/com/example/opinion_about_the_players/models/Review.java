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

    ////connection with club
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Club club;


    @Column(name = "anons")
    private String anons;

    @Column(name = "fullRewiew")
    private String fullRewiew;


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
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

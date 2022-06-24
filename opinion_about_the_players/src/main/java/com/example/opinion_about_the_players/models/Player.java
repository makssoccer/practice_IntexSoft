package com.example.opinion_about_the_players.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "player")
public class Player {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    ////connection with country
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Country country;

    ////connection with club
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Club club;

    ////connection with reviews
    @OneToMany(mappedBy = "player", fetch = FetchType.LAZY)
    private List<Review> reviews;


    private Short age;
    private String namePlayer;
    private String nickname;
    private String fullText;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviewss(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

//    private int views;

    public String getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /*public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }*/

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String full_text) {
        this.fullText = full_text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player() {
    }
    public Player(String namePlayer, String nickname, String fullText, Club club,Country country) {
        this.namePlayer = namePlayer;
        this.nickname = nickname;
        this.fullText = fullText;
        this.club = club;
        this.country=country;
    }

}

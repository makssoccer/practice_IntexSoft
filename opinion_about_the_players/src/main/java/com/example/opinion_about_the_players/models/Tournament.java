package com.example.opinion_about_the_players.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tournament")
public class Tournament {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    ////connection with clubs
    @ManyToMany(mappedBy="tournament", fetch = FetchType.LAZY)
    private List<Club> club;

    ////connection with country
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private  Country country;


    private String nameTournament;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Club> getClub() {
        return club;
    }

    public void setClub(List<Club> club) {
        this.club = club;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameTournament() {
        return nameTournament;
    }

    public void setNameTournament(String nameTournament) {
        this.nameTournament = nameTournament;
    }

    public void Country(){
    };

    public void Country(String nameTournament, Country countries){
        this.nameTournament=nameTournament;
        this.country=countries;
    };

}
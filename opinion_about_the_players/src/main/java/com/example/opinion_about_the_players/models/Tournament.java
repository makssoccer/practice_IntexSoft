package com.example.opinion_about_the_players.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tournament")
public class Tournament {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



    @ManyToMany(mappedBy="tournament", fetch = FetchType.LAZY)
    private List<Club> club;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "country_tournament",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id"))
    private List<Country> country;


    private String nameTournament;

    public List<Country> getCountry() {
        return country;
    }

    public void setCountry(List<Country> country) {
        this.country = country;
    }

    public void setCountries(List<Country> countries) {
        country.addAll(countries);
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

    public void Country(String nameTournament, List<Country> countries){
        this.nameTournament=nameTournament;
        this.country=countries;
    };

}
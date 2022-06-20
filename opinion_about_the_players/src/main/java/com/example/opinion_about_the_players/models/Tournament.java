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


    private String nameTournament;


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
}
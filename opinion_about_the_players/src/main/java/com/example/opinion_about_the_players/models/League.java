package com.example.opinion_about_the_players.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "league")
public class League {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "league_club",
            joinColumns = @JoinColumn(name = "club_id"),
            inverseJoinColumns = @JoinColumn(name = "league_id"))
    private List<Club> club;



    private String name_league;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")


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
    public String getName_league() {
        return name_league;
    }

    public void setName_league(String name_league) {
        this.name_league = name_league;
    }
}
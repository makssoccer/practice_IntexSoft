package com.example.opinion_about_the_players.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "club")
public class Club {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "club", fetch = FetchType.LAZY)
    private List<Player> players;



    @ManyToMany(mappedBy="club", fetch = FetchType.LAZY)
    private List<League> league;

    private String name_club;


    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")

    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }


    public List<League> getLeague() {
        return league;
    }

    public void setLeague(List<League> league) {
        this.league = league;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName_club() {
        return name_club;
    }
    public void setName_club(String name_club) {
        this.name_club = name_club;
    }

    public Club() {
    }
    public Club(String name_club) {
        this.name_club = name_club;
    }
}
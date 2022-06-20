package com.example.opinion_about_the_players.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "club")
public class Club {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "club", fetch = FetchType.LAZY)
    private List<Player> players;




    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tournament_club",
            joinColumns = @JoinColumn(name = "club_id"),
            inverseJoinColumns = @JoinColumn(name = "tournament_id"))
    private List<Tournament> tournament;


    private String name_club;

    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }


    public List<Tournament> getTournament() {
        return tournament;
    }

    public void setTournament(List<Tournament> tournament) {
        this.tournament = tournament;
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
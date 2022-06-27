package com.example.opinion_about_the_players.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "club")
public class Club {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

////connection with players
    @OneToMany(mappedBy = "club", fetch = FetchType.LAZY)
    private List<Player> players;

////connection with reviews

////connection with tournament
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tournament_club",
            joinColumns = @JoinColumn(name = "club_id"),
            inverseJoinColumns = @JoinColumn(name = "tournament_id"))
    private List<Tournament> tournament;


    private String nameClub;

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
    public void setTournaments(List<Tournament> tournaments) {
        tournament.addAll(tournaments) ;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNameClub() {
        return nameClub;
    }
    public void setNameClub(String nameClub) {
        this.nameClub = nameClub;
    }

    public Club() {
    }
    public Club(String nameClub) {
        this.nameClub = nameClub;
    }
}
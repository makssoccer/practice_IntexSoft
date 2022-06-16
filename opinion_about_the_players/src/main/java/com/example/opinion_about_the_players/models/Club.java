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
    @OneToMany(mappedBy = "club", fetch = FetchType.EAGER)
    private List<Player> players;

    private String name_club;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")


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
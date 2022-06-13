package com.example.opinion_about_the_players.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Short age;
    private String name_player, nickname, full_text;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")


//    @ManyToOne
//    @JoinColumn(name = "club_id", nullable = false)
//    private Club club;
//

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

//    private int views;

    public String getName_player() {
        return name_player;
    }

    public void setName_player(String name_player) {
        this.name_player = name_player;
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

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player() {
    }
    public Player(String name_player, String anons, String full_text) {
        this.name_player = name_player;
        this.nickname = anons;
        this.full_text = full_text;

    }
}

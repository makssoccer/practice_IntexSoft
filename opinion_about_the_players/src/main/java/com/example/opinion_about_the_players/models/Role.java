package com.example.opinion_about_the_players.models;
import org.springframework.security.core.GrantedAuthority;

public enum Role {
    USER,
    ADMIN;

    Role(){
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
package com.example.opinion_about_the_players.service;

import com.example.opinion_about_the_players.models.Club;

import com.example.opinion_about_the_players.models.League;
import com.example.opinion_about_the_players.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class LeagueServise {
    @Autowired
    private LeagueRepository leagueRepository;

    public Model getLeagues(Model model){
        Iterable<League> leagues = leagueRepository.findAll();
        return model.addAttribute("leagues",leagues);
    };

    public  void saveLeagueToDB(String name_league)
    {
        League league =new League();
        league.setName_league(name_league);
        leagueRepository.save(league);
    }
}

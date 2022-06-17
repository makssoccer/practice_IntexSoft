package com.example.opinion_about_the_players.service;

import com.example.opinion_about_the_players.models.Club;
import com.example.opinion_about_the_players.models.League;
import com.example.opinion_about_the_players.models.Player;
import com.example.opinion_about_the_players.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClubServise {
    @Autowired
    private ClubRepository clubRepository;

    public Model getClubs(Model model){
        Iterable<Club> clubs = clubRepository.findAll();
        return model.addAttribute("clubs",clubs);
    };
    public  void saveClubToDB(String name_club, List<League> league)
    {
        Club club =new Club();
        club.setName_club(name_club);
        club.setLeague(league);
        clubRepository.save(club);
    }
    public Model getInfoByClubs(long id, Model model){
        Optional<Club> club = clubRepository.findById(id);
        ArrayList<Club> resol= new ArrayList<>();
        club.ifPresent(resol::add);
        return model.addAttribute("club",resol);
    }

    public  void deleteClubOnDB(long id)
    { Club club = clubRepository.findById(id).orElseThrow();
        clubRepository.delete(club);}
}

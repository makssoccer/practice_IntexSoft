package com.example.opinion_about_the_players.conrtrollers;

import com.example.opinion_about_the_players.models.Club;
import com.example.opinion_about_the_players.models.League;
import com.example.opinion_about_the_players.repository.ClubRepository;
import com.example.opinion_about_the_players.repository.LeagueRepository;
import com.example.opinion_about_the_players.service.ClubServise;
import com.example.opinion_about_the_players.service.LeagueServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private ClubServise clubServise;
    @Autowired
    private LeagueRepository leagueRepository;
    @Autowired
    private LeagueServise leagueServise;



///////Вывод всех клубов на экран
    @GetMapping("/clubs")
    public String clubMain(Model model){
        clubServise.getClubs(model);
        return "clubPackage/clubs";
    }
//////
    @GetMapping("/clubs/add")
    public String clubAdd( Model model){
        leagueServise.getLeagues(model);
        return "clubPackage/clubs-add";
    }
    ////Добавление клуба
    @PostMapping("/clubs/add")
    public String clubPostAdd(@RequestParam String name_club, @RequestParam List<League> league, @RequestParam String name_league, Model model) {
        if (name_league != "") {
            leagueServise.saveLeagueToDB(name_league);
        }
        if (name_club != "") {
        clubServise.saveClubToDB(name_club,league);
        }
            return "redirect:/clubs";

    }

    @GetMapping("/clubs/{id}")
    public String clubDetails(@PathVariable(value="id") long id, Model model){
        if(!clubRepository.existsById(id)){
            return "redirect:/clubs";
        }
        clubServise.getInfoByClubs(id,model);
//        playerServise.getNamePlayersInClub(id, model);
      return "clubPackage/clubs-details";
    }
    @PostMapping("/clubs/{id}remove")
    public String clubPostDelete(@PathVariable(value="id") long id,Model model) {
        clubServise.deleteClubOnDB(id);
        return "redirect:/clubs";
    }


}
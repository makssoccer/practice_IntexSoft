package com.example.opinion_about_the_players.conrtrollers;

import com.example.opinion_about_the_players.models.Tournament;
import com.example.opinion_about_the_players.repository.ClubRepository;
import com.example.opinion_about_the_players.repository.TournamentRepository;
import com.example.opinion_about_the_players.service.ClubServise;
import com.example.opinion_about_the_players.service.TournamentServise;
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
    private TournamentRepository tournamentRepository;
    @Autowired
    private TournamentServise tournamentServise;



///////Вывод всех клубов на экран
    @GetMapping("/clubs")
    public String clubMain(Model model){
        clubServise.getClubs(model);
        return "clubPackage/clubs";
    }
//////
    @GetMapping("/clubs/add")
    public String clubAdd( Model model){
        tournamentServise.getTournaments(model);
        return "clubPackage/clubs-add";
    }
    ////Добавление клуба
    @PostMapping("/clubs/add")
    public String clubPostAdd(@RequestParam String name_club, @RequestParam List<Tournament> tournament, @RequestParam String nameTournament, Model model) {
        if (nameTournament != "") {
            tournamentServise.saveTournamentToDB(nameTournament);
        }

        if (name_club != "") {
        clubServise.saveClubToDB(name_club, tournament);
        }
            return "redirect:/clubs";
    }

    @GetMapping("/clubs/{id}")
    public String clubDetails(@PathVariable(value="id") long id, Model model){
        if(!clubRepository.existsById(id)){
            return "redirect:/clubs";
        }
        tournamentServise.getTournaments(model);
        clubServise.getInfoByClubs(id,model);

//        playerServise.getNamePlayersInClub(id, model);
      return "clubPackage/clubs-details";
    }
    @PostMapping("/clubs/{id}")
    public String clubPostDetails(@PathVariable(value="id") long id,@RequestParam String name_club, @RequestParam List<Tournament> tournament, Model model){
        if(!clubRepository.existsById(id)){
            return "redirect:/clubs";
        }
        clubServise.editClubToDB(id,name_club, tournament);
//        playerServise.getNamePlayersInClub(id, model);
        return "redirect:/clubs-details";
    }

    @GetMapping("/clubs/{id}edit")
    public String clubEdit(@PathVariable(value="id") long id,Model model){
        if(!clubRepository.existsById(id)){
            return "redirect:/clubs";}
        tournamentServise.getTournaments(model);
        clubServise.getInfoByClubs(id, model);
        return "clubPackage/clubs-edit";
    }
    @PostMapping("/clubs/{id}edit")
    public String clubPostUbdate(@PathVariable(value = "id") long id,@RequestParam String name_club, @RequestParam List<Tournament> tournament,Model model){
        clubServise.editClubToDB(id,name_club,tournament);
        return "redirect:/clubs";
    }
    @PostMapping("/clubs/{id}remove")
    public String clubPostDelete(@PathVariable(value="id") long id,Model model) {
        clubServise.deleteClubOnDB(id);
        return "redirect:/clubs";
    }


}
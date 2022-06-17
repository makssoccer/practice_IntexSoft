package com.example.opinion_about_the_players.conrtrollers;

import com.example.opinion_about_the_players.models.Club;
import com.example.opinion_about_the_players.repository.ClubRepository;
import com.example.opinion_about_the_players.repository.PlayerRepository;
import com.example.opinion_about_the_players.service.ClubServise;
import com.example.opinion_about_the_players.service.PlayerServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlayerServise playerServise;
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private ClubServise clubServise;

    @GetMapping("/players")
    public String playerMain(Model model){
        playerServise.getPlayers(model);
        return "playerPackage/players";
    }

    @GetMapping("/players/add")
    public String playerAdd( Model model){
        clubServise.getClubs(model);
        return "playerPackage/players-add";

    }
    /////////Создание Игрока
    @PostMapping("/players/add")
    public String playerPostAdd(@RequestParam String name_player , @RequestParam  String nickname, @RequestParam String full_text, @RequestParam Club club, Model model) {
        playerServise.savePlayerToDB(name_player, nickname,full_text,club);
        return "redirect:/players";
    }
    ////////Страница конкретного Игрока
    @GetMapping("/players/{id}")
    public String playerDetails(@PathVariable(value="id") long id, Model model){
        if(!playerRepository.existsById(id)){
            return "redirect:/players";
        }
        playerServise.getInfoByPlayers(id,model);
        return "playerPackage/players-details";
    }
    //////Получение данных об Игроке для его дальнейшего редактирования
    @GetMapping("/players/{id}edit")
    public String playerEdit(@PathVariable(value="id") long id, Model model){
        if(!playerRepository.existsById(id)){
            return "redirect:/players";}
        playerServise.getInfoByPlayers(id,model);
        clubServise.getClubs(model);
        return "playerPackage/players-edit";
    }
    ////Редактирование данных Игрока
    @PostMapping("/players/{id}edit")
    public String playerPostUbdate(@PathVariable(value="id") long id, @RequestParam String name_player,@RequestParam Club club , @RequestParam String nickname, @RequestParam String full_text, Model model) {
        playerServise.editPlayerToDB(id, name_player, nickname,full_text,club);
        return "redirect:/players";}

    ////Удаление Игрока
    @PostMapping("/players/{id}remove")
    public String playerPostDelete(@PathVariable(value="id") long id,Model model) {
        playerServise.deletePlayerOnDB(id);
        return "redirect:/players";
    }
}

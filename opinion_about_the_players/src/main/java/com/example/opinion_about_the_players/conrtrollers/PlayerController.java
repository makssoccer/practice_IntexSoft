package com.example.opinion_about_the_players.conrtrollers;

import com.example.opinion_about_the_players.models.Club;
import com.example.opinion_about_the_players.models.Country;
import com.example.opinion_about_the_players.models.Player;
import com.example.opinion_about_the_players.models.Review;
import com.example.opinion_about_the_players.repository.PlayerRepository;
import com.example.opinion_about_the_players.service.ClubServise;
import com.example.opinion_about_the_players.service.CountryServise;
import com.example.opinion_about_the_players.service.PlayerServise;
import com.example.opinion_about_the_players.service.ReviewServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    private ClubServise clubServise;
    @Autowired
    private CountryServise countryServise;
    @Autowired
    private ReviewServise reviewServise;

    @GetMapping("/players")
    public String playerMain(Model model){
        playerServise.getPlayers(model);
        return "playerPackage/players";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/players/add")
    public String playerAdd( Model model){
        clubServise.getClubs(model);
        countryServise.getCountries(model);

        return "playerPackage/players-add";

    }
    /////////create player
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/players/add")
    public String playerPostAdd(@RequestParam String namePlayer, @RequestParam  String nickname, @RequestParam String fullText, @RequestParam Club club, @RequestParam Country country, Model model) {
        playerServise.savePlayerToDB(namePlayer, nickname, fullText, club, country);
        return "redirect:/players";
    }
    ////////Страница конкретного Игрока

    @GetMapping("/players/{id}")
    public String playerDetails(@PathVariable(value="id") long id, Model model){
    if(!playerRepository.existsById(id)){
            return "redirect:/players";
        }
        playerServise.getInfoByPlayers(id,model);
        reviewServise.getPlayerReviews(id,model);
        return "playerPackage/players-details";
    }

    @PostMapping("/players/{id}")
    public String playerPostReview(@PathVariable(value="id") long id,@RequestParam String anons, @RequestParam String fullReview, Model model){
        reviewServise.saveRiviewsPlayer(anons,fullReview,id);
        return "redirect:/players";
    }
    //////Получение данных об Игроке для его дальнейшего редактирования
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/players/{id}edit/")
    public String playerEdit(@PathVariable(value="id") long id, Model model){
        if(!playerRepository.existsById(id)){
            return "redirect:/players";}
        playerServise.getInfoByPlayers(id,model);
        clubServise.getClubs(model);
        countryServise.getCountries(model);
        return "playerPackage/players-edit";
    }
    ////Редактирование данных Игрока
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/players/{id}edit/")
    public String playerPostUbdate(@PathVariable(value="id") long id, @RequestParam String namePlayer, @RequestParam Club club ,@RequestParam Country country , @RequestParam String nickname, @RequestParam String fullText, Model model) {
        playerServise.editPlayerToDB(id, namePlayer, nickname, fullText,club,country);
        return "redirect:/players";}

    ////Удаление Игрока
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/players/{id}remove")
    public String playerPostDelete(@PathVariable(value="id") long id,Model model) {
        playerServise.deletePlayerOnDB(id);
        return "redirect:/players";
    }
}

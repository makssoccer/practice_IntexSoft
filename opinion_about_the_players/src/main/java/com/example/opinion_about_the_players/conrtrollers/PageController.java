package com.example.opinion_about_the_players.conrtrollers;

import com.example.opinion_about_the_players.models.Club;
import com.example.opinion_about_the_players.models.Player;
import com.example.opinion_about_the_players.repository.ClubRepository;
import com.example.opinion_about_the_players.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class PageController {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private ClubRepository clubRepository;



    @GetMapping("/players")
    public String playerMain(Model model){
        Iterable<Player> players = playerRepository.findAll();

        model.addAttribute("players",players);

        return "players";
    }
////Добавить игрока
    @GetMapping("/players/add")
    public String playerAdd( Model model){

        Iterable<Club> clubs = clubRepository.findAll();

        model.addAttribute("clubs",clubs);
        return "players-add";
    }
@PostMapping("/players/add")
    public String playerPostAdd(@RequestParam String name_player ,@RequestParam Club club ,  @RequestParam  String nickname, @RequestParam String full_text, Model model) {
        Player player = new Player(name_player, nickname,full_text,club);
         playerRepository.save(player);
        return "redirect:/players";
   }

//    @PostMapping("/blog/add")
//    public String blogPostAdd(@RequestParam("file") MultipartFile file, @RequestParam("title") String title, @RequestParam("anons") String anons, @RequestParam("full_text") String full_text, Model model){
//        playrsServise.saveProductToDB(file,title,anons,full_text);
//        return "redirect:/blog";
//    }
//
    @GetMapping("/players/{id}")
    public String playerDetails(@PathVariable(value="id") long id, Model model){
        if(!playerRepository.existsById(id)){
            return "redirect:/players";
        }
        Optional<Player> player = playerRepository.findById(id);
        ArrayList<Player> res= new ArrayList<>();
        player.ifPresent(res::add);
        model.addAttribute("player",res);
        return "players-details";
    }
    @GetMapping("/players/{id}edit")
    public String playerEdit(@PathVariable(value="id") long id, Model model){
        if(!playerRepository.existsById(id)){
            return "redirect:/players";
        }

        Optional<Player> player = playerRepository.findById(id);
        ArrayList<Player> res= new ArrayList<>();
        player.ifPresent(res::add);
        model.addAttribute("player",res);

        Iterable<Club> clubs = clubRepository.findAll();

        model.addAttribute("clubs",clubs);

        return "players-edit";
    }
//    @PostMapping("/blog/{id}edit")
//    public String blogPostUbdate(@RequestParam("file") MultipartFile file,@PathVariable(value="id") long id, @RequestParam String title,@RequestParam String anons,@RequestParam String full_text, Model model) {
//        playrsServise.editProductToDB(id,file,title,anons,full_text);
//
//        return "redirect:/blog";
//    }
//
    @PostMapping("/players/{id}edit")
    public String playerPostUbdate(@PathVariable(value="id") long id, @RequestParam String name_player,@RequestParam Club club , @RequestParam String nickname, @RequestParam String full_text, Model model) {

        Player player= playerRepository.findById(id).orElseThrow();
        player.setName_player(name_player);
        player.setNickname(nickname);
        player.setFull_text(full_text);
        player.setClub(club);
        playerRepository.save(player);
        return "redirect:/players";}

    @PostMapping("/players/{id}remove")
    public String playerPostDelete(@PathVariable(value="id") long id,Model model) {
        Player player = playerRepository.findById(id).orElseThrow();
        playerRepository.delete(player);
        return "redirect:/players";
    }


    @GetMapping("/clubs")
    public String clubMain(Model model){
        Iterable<Club> clubs = clubRepository.findAll();

        model.addAttribute("clubs",clubs);

        return "clubs";
    }

    @GetMapping("/clubs/add")
    public String clubAdd( Model model){

        return "clubs-add";
    }
    ////Добавить клуб
    @PostMapping("/clubs/add")
    public String clubPostAdd(@RequestParam String name_club,  Model model) {
        Club club = new Club (name_club);
        clubRepository.save(club);
        return "redirect:/clubs";
    }
    @GetMapping("/clubs/{id}")
    public String clubDetails(@PathVariable(value="id") long id, Model model){
        if(!clubRepository.existsById(id)){
            return "redirect:/clubs";
        }
        Optional<Club> club = clubRepository.findById(id);
        ArrayList<Club> resol= new ArrayList<>();
        club.ifPresent(resol::add);
        model.addAttribute("club",resol);
        return "clubs-details";
    }
    @PostMapping("/clubs/{id}remove")
    public String clubPostDelete(@PathVariable(value="id") long id,Model model) {
        Club club = clubRepository.findById(id).orElseThrow();
        clubRepository.delete(club);
        return "redirect:/clubs";
    }


}
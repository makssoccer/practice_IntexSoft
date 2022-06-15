package com.example.opinion_about_the_players.service;

import com.example.opinion_about_the_players.models.Club;
import com.example.opinion_about_the_players.models.Player;
import com.example.opinion_about_the_players.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PlayerServise {

    @Autowired
    private PlayerRepository playerRepository;

    public Model getPlayers(Model model){
        Iterable<Player> players = playerRepository.findAll();
        return model.addAttribute("players",players);
    };

    public  void savePlayerToDB(String name_player, String nickname, String full_text, Club club)
    {
        Player player =new Player();
        player.setName_player(name_player);
        player.setNickname(nickname);
        player.setFull_text(full_text);
        player.setClub(club);
        playerRepository.save(player);
    }
    public Model getInfoByPlayers(long id, Model model){

        Optional<Player> player = playerRepository.findById(id);
        ArrayList<Player> res= new ArrayList<>();
        player.ifPresent(res::add);
        return model.addAttribute("player",res);
    }
    public  void editPlayerToDB(long id,String name_player, String nickname, String full_text, Club club)
    {
        Player player= playerRepository.findById(id).orElseThrow();
        player.setName_player(name_player);
        player.setNickname(nickname);
        player.setFull_text(full_text);
        player.setClub(club);
        playerRepository.save(player);
    }
}

package com.example.opinion_about_the_players.service;

import com.example.opinion_about_the_players.models.Club;
import com.example.opinion_about_the_players.models.Country;
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

    /////заполняем
    public Model getPlayers(Model model){
        Iterable<Player> players = playerRepository.findAll();
        return model.addAttribute("players",players);
    };


    public  void savePlayerToDB(String namePlayer, String nickname, String fullText, Club club, Country country)
    {
        Player player =new Player();
        player.setNamePlayer(namePlayer);
        player.setNickname(nickname);
        player.setFullText(fullText);
        player.setClub(club);
        player.setCountry(country);
        playerRepository.save(player);
    }
    public Model getInfoByPlayers(long id, Model model){

        Optional<Player> player = playerRepository.findById(id);
        ArrayList<Player> res= new ArrayList<>();
        player.ifPresent(res::add);
        return model.addAttribute("player",res);
    }
//    public Model getNamePlayersInClub(long club_id, Model model){
//
//        Optional<Player> players = playerRepository.findByclub_id(club_id);
//        return model.addAttribute("players",players);
//    }

    public  void editPlayerToDB(long id, String namePlayer, String nickname, String fullText, Club club, Country country)
    {
        Player player= playerRepository.findById(id).orElseThrow();
        player.setNamePlayer(namePlayer);
        player.setNickname(nickname);
        player.setFullText(fullText);
        player.setClub(club);
        player.setCountry(country);
        playerRepository.save(player);
    }
    public  void deletePlayerOnDB(long id)
    { Player player = playerRepository.findById(id).orElseThrow();
        playerRepository.delete(player);}

}

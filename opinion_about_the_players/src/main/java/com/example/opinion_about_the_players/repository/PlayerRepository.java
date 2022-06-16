package com.example.opinion_about_the_players.repository;


import com.example.opinion_about_the_players.models.Club;
import com.example.opinion_about_the_players.models.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends CrudRepository<Player,Long> {


//    Optional<Player> findByclub_id(long club_id);

}

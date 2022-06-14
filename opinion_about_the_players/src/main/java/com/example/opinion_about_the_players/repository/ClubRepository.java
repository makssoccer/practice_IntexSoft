package com.example.opinion_about_the_players.repository;

import com.example.opinion_about_the_players.models.Club;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface ClubRepository extends CrudRepository<Club,Long> {

//    Optional<Club> findByName(String club_name);

}
package com.example.opinion_about_the_players.repository;

import com.example.opinion_about_the_players.models.Club;
import org.springframework.data.repository.CrudRepository;




public interface ClubRepository extends CrudRepository<Club,Long> {

//    @EntityGraph(attributePaths = "player")
//    @Query("select c from Club c where c.id = ?1")
//    Club getByNameWithPlayer(Long id);

}
package com.example.opinion_about_the_players.repository;

import com.example.opinion_about_the_players.models.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepositiry extends CrudRepository<Review,Long> {
}

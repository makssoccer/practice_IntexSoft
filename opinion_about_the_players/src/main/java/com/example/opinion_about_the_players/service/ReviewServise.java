package com.example.opinion_about_the_players.service;

import com.example.opinion_about_the_players.models.Player;
import com.example.opinion_about_the_players.models.Review;
import com.example.opinion_about_the_players.repository.ReviewRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ReviewServise {

    @Autowired
    ReviewRepositiry reviewRepository;

    public Model getReviews(Model model){
        Iterable<Review> reviews= reviewRepository.findAll();
        return model.addAttribute("reviews",reviews);
    }

    public void saveRiviewsPlayer(String anons, String fullReviews, Player player) {
        Review review = new Review();
        review.setAnons(anons);
        review.setFullRewiew(fullReviews);
        review.setPlayer(player);
        reviewRepository.save(review);
    }
}

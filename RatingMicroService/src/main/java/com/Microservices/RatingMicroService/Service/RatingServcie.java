package com.Microservices.RatingMicroService.Service;

import com.Microservices.RatingMicroService.Entity.Ratings;
import com.Microservices.RatingMicroService.RatingRepository.RatingJPA;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServcie {
    @Autowired
    private RatingJPA ratingJPA;

    public List<Ratings> getRating() {
        return ratingJPA.findAll();

    }

    public Ratings saveRating(Ratings rating) {
        return ratingJPA.save(rating);
    }

    public Ratings updateRating(int id, Ratings rating) {
        Ratings existingrating = ratingJPA.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Ratings not found"));
        existingrating.setRating(rating.getRating());
        existingrating.setHotelid(rating.getHotelid());
        existingrating.setUserId(rating.getUserId());
        existingrating.setFeedback(rating.getFeedback());
        return  ratingJPA.save(existingrating);
    }

    public Ratings getRatingByid(int ratingId) {
        return ratingJPA.findById(ratingId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Requested RatingId " + ratingId + " not found"
                ));
    }

    public Ratings findbyUserId(int userId) {
        return ratingJPA.findByuserId(userId);
    }
    
    public String deleteByratingId(int rid) {
        ratingJPA.deleteById(rid);
        return "RatingID="+rid+ "ratings deleted successfully";
    }
    
}

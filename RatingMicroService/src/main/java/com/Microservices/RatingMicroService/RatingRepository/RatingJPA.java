package com.Microservices.RatingMicroService.RatingRepository;

import com.Microservices.RatingMicroService.Entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface RatingJPA extends JpaRepository<Ratings, Integer> {

    public Ratings findByuserId(int userId);
}

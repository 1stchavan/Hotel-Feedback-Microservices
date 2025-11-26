package com.Microservices.UserMicroService.Service;

import com.Microservices.UserMicroService.Entity.Ratings;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATINGMICROSERVICE")
public interface FeinService {

    @GetMapping("/ratings/{id}")
    public List<Ratings> getRatingByUserIdFromRatingApi(@PathVariable int id);
}

package com.Microservices.RatingMicroService.Controler;

import com.Microservices.RatingMicroService.Entity.Ratings;
import com.Microservices.RatingMicroService.Service.RatingServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ratings")
@RestController
public class Controller {

    @Autowired
    RatingServcie ratingServcie;

    @GetMapping
    public ResponseEntity<List<Ratings>> getRatingServcie() {
        return ResponseEntity.status(HttpStatus.OK).body(ratingServcie.getRating());
    }

    @PostMapping
    public ResponseEntity<Ratings> saveRating(@RequestBody Ratings rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingServcie.saveRating(rating));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ratings> getRating(@PathVariable int id) {
        return  ResponseEntity.status(HttpStatus.OK).body(ratingServcie.getRatingByid(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Ratings> updateRating(@PathVariable int id, @RequestBody Ratings rating) {
        return ResponseEntity.status(HttpStatus.OK).body(ratingServcie.updateRating(id,rating));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRating(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(ratingServcie.deleteByratingId(id));
    }

}

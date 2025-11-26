package com.Microservices.UserMicroService.Controler;

import com.Microservices.UserMicroService.Entity.Ratings;
import com.Microservices.UserMicroService.Entity.User;
import com.Microservices.UserMicroService.Service.FeinService;
import com.Microservices.UserMicroService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    FeinService  feinService;
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable int id) {
        List<Ratings> rating= feinService.getRatingByUserIdFromRatingApi(id);

        User foundUser = userService.findById(id);
        foundUser.setRatings((Ratings) rating);
        return ResponseEntity.status(HttpStatus.OK).body(foundUser);


    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user)
    {
        User savedUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);

    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user)
    {
        User updateduser= userService.update(id, user);
        return ResponseEntity.status(HttpStatus.OK).body(updateduser);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id)
    {
        userService.deleteById(id);
        return ResponseEntity.ok("User with id " + id + " deleted");    }
}

package com.Microservices.UserMicroService.Service;

import com.Microservices.UserMicroService.Entity.Ratings;
import com.Microservices.UserMicroService.Entity.User;
import com.Microservices.UserMicroService.UserRepository.UserJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.SequencedCollection;

@Service
public class UserService {


    @Autowired
    UserJPARepo userJPARepo;

    @Autowired
    private UserJPARepo userrepository;

    public List<User> findAll() {

        return userrepository.findAll();
    }

    public User save(User user) {
        return userrepository.save(user);
    }

    public User findById(Integer id) {

         return userrepository.findById(id).orElse(null);
    }

    public User update(int id, User user) {

        User existingUser = userrepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "User with ID " + id + " not available"
                ));

        existingUser.setUsername(user.getUsername());
        existingUser.setPhone(user.getPhone());
        existingUser.setEmail(user.getEmail());

        userrepository.save(existingUser);
         return existingUser;

    }

    public void deleteById(int id) {
        userrepository.deleteById(id);
    }

}

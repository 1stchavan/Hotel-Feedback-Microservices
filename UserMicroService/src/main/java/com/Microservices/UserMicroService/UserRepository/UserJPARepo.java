package com.Microservices.UserMicroService.UserRepository;

import com.Microservices.UserMicroService.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJPARepo extends JpaRepository<User, Integer> {
}

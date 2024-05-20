package com.motorny.ss.chemistryservice.repository;

import com.motorny.ss.chemistryservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
//    @Query(value = "FROM User user JOIN FETCH user.reviews")
//    List<User> findAll();
}

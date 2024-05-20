package com.motorny.ss.chemistryservice.repository;

import com.motorny.ss.chemistryservice.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = "reviews")
    List<User> findAll();
}

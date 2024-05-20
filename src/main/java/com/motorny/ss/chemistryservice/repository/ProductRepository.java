package com.motorny.ss.chemistryservice.repository;

import com.motorny.ss.chemistryservice.model.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = "reviews")
    List<Product> findAll();
}

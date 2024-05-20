package com.motorny.ss.chemistryservice.repository;

import com.motorny.ss.chemistryservice.model.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
//    @Query(value = "FROM Product product JOIN FETCH product.brand JOIN FETCH product.category JOIN FETCH product.reviews")
//    List<Product> findAll();

//    @EntityGraph(attributePaths = { "brand", "category", "reviews" })
//    @Query(value = "FROM Product product JOIN FETCH product.brand JOIN FETCH product.category JOIN FETCH product.reviews")
//    List<Product> findAll();

    @EntityGraph(attributePaths = {"brand", "category", "reviews"})
    @Query(value = "FROM Product product JOIN FETCH product.brand JOIN FETCH product.category JOIN FETCH product.reviews")
    List<Product> findAll();
}

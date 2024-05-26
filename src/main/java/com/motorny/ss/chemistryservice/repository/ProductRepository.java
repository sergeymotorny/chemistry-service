package com.motorny.ss.chemistryservice.repository;

import com.motorny.ss.chemistryservice.model.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = "reviews")
    List<Product> findAll();

    @Query(value = "SELECT p FROM Product p WHERE p.price > ?1")
    List<Product> findProductByPrice(Integer amount);

    @Query(value = "SELECT b.Name, c.Name, p.Price, count(p.Price) " +
            "FROM Products p " +
            "inner join Brands b on b.BrandID = p.BrandID " +
            "inner join Categories c on c.CategoryID = p.CategoryID " +
            "GROUP BY b.Name, c.Name, p.Price " +
            "ORDER BY p.Price", nativeQuery = true)
    List<Object[]> countProductsByPriceAndBrandCategory();

    @Query(value = "CALL findProductsByBrandId(:id)", nativeQuery = true)
    List<Product> findProductsByBrandId();
}

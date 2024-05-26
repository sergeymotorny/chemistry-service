package com.motorny.ss.chemistryservice.repository;

import com.motorny.ss.chemistryservice.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query(value = "SELECT b.country, count(b.id) FROM Brand b WHERE b.country = ?1 GROUP BY b.country")
    List<Object[]> countBrandsByCountry(String country);
}

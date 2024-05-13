package com.motorny.ss.chemistryservice.repository;

import com.motorny.ss.chemistryservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

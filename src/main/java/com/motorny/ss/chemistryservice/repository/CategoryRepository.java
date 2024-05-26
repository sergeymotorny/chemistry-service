package com.motorny.ss.chemistryservice.repository;

import com.motorny.ss.chemistryservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

package com.motorny.ss.chemistryservice.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.EntityGraph;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BrandID")
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CategoryID", nullable = false)
    private Category category;

    @Column(columnDefinition = "Price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "Description")
    private String description;

    @Column(name = "ExpiryDate")
    private LocalDate expiryDate;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Review> reviews = new LinkedHashSet<>();
}

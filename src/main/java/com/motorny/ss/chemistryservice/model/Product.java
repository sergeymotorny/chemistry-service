package com.motorny.ss.chemistryservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "BrandID")
    private Brand brandId;

    @ManyToOne
    @JoinColumn(name = "CategoryID", nullable = false)
    private Category categoryId;

    @Column(columnDefinition = "Price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "Description")
    private String description;

    @Column(name = "ExpiryDate")
    private LocalDate expiryDate;

    @OneToMany(mappedBy = "productId", cascade = CascadeType.ALL)
    private Set<Review> reviews = new LinkedHashSet<>();
}

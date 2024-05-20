package com.motorny.ss.chemistryservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "Brands")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BrandID")
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Country", length = 50)
    private String country;

    @Column(name = "YearFounded", nullable = false)
    private int yearFounded;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private Set<Product> products = new LinkedHashSet<>();

}

package com.motorny.ss.chemistryservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank
    @Size(max = 50)
    @Column(name = "Name", nullable = false)
    private String name;

    @NotBlank
    @Size(max = 30)
    @Column(name = "Country", length = 50)
    private String country;

    @NotBlank
    @Size(min = 3, max = 30)
    @Column(name = "YearFounded", nullable = false)
    private int yearFounded;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private Set<Product> products = new LinkedHashSet<>();

}

package com.motorny.ss.chemistryservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "Categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID", nullable = false)
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(name = "Name", nullable = false)
    private String name;

    @Size(max = 1000)
    @Column(name = "Description")
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Product> products = new LinkedHashSet<>();
}

package com.motorny.ss.chemistryservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "Categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID", nullable = false)
    private long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Description")
    private String description;

    @OneToMany(mappedBy = "categoryId", cascade = CascadeType.ALL)
    private Set<Product> products = new LinkedHashSet<>();
}

package com.motorny.ss.chemistryservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private long id;

    @Column(name = "Name", nullable = false, length = 30)
    private String name;

    @Email
    @Column(name = "Email", unique = true, nullable = false, length = 50)
    private String email;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    private Set<Review> reviews = new LinkedHashSet<>();
}

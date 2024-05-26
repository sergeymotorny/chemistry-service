package com.motorny.ss.chemistryservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Size(max = 20)
    @Column(name = "Name", nullable = false, length = 30)
    private String name;

    @Size(max = 50)
    @Email
    @Column(name = "Email", unique = true, nullable = false, length = 50)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Review> reviews = new LinkedHashSet<>();
}

package com.motorny.ss.chemistryservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(exclude = "product")
@Table(name = "Reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReviewID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductID", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @NotBlank(message = "Rating cannot be empty")
    @Size(max = 1)
    @Column(name = "Rating")
    private short rating;

    @NotBlank
    @Size(max = 255)
    @Column(name = "Comment")
    private String comment;

    @NotBlank
    @Column(name = "CreateReview")
    private LocalDateTime createReview;
}

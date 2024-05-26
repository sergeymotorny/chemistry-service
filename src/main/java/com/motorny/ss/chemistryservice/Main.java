package com.motorny.ss.chemistryservice;

import com.motorny.ss.chemistryservice.model.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {

    private static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Review> reviews = entityManager.createQuery("""
                        select review
                        from Review review
                        join fetch review.product p
                        join fetch review.user u
                        """, Review.class)
                .getResultList();

        for (Review review : reviews) {
            LOGGER.info(
                    "The ID '{}' with Product '{}' got this review from User '{}': Rating '{}', Comment '{}'",
                    review.getId(),
                    review.getProduct().getId(),
                    review.getUser().getId(),
                    review.getRating(),
                    review.getComment()
            );
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}

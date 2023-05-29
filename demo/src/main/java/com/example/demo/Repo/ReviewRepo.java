package com.example.demo.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Review;


@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

    // Optional<Review> findByMovieId(Long movieId);


    // void deleteByReviewerId(Long reviewerId);
}

package com.example.demo.Repo;



// import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Review;
import com.example.demo.Model.Reviewer;

import java.util.List;


@Repository
public interface ReviewerRepo   extends JpaRepository<Reviewer, Long> {
//   public Review review;

//   List<Review> findBYMovieId(Integer movie);
// List<Review> findByMovieId(Long movieId);




    
}

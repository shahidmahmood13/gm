package com.example.demo.Controller;


import java.util.Optional;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Review;
import com.example.demo.Repo.ReviewRepo;

import io.micrometer.core.instrument.Meter.Id;

@RestController
@RequestMapping("/review")
public class ReviewController {
    
    @Autowired
    private  ReviewRepo reviewRepo;

    @PostMapping("/post")
    public String addReview(@RequestBody Review review){
        reviewRepo.save(review);
        return "review done:  " + review.getReviewText();
    }

    @GetMapping("/getall")
    public List<Review> getAllergic(){
        return reviewRepo.findAll();
      
    }


    // 3nd test case  get reviews by id

    @GetMapping("/{id}")
    public Optional<Review> getReviewsbyMoviId(@PathVariable  Long id){
        return reviewRepo.findById(id);

    }

    @DeleteMapping("/delete/{id}")
    public String Deletebyid(@PathVariable() Long id){
        reviewRepo.deleteById(id);
        return id + "deleted";
    }



    // delete review by  by reviewerid

    // @DeleteMapping("/{reviewerId}/review/{reviewId}")
    // public String  deleteReviewe(@PathVariable Long reviewerId, @PathVariable Long RevieweId){
    //     reviewRepo.deleteById(reviewerId);
    //     return reviewerId + " deleted";
    // }
    // @DeleteMapping("/delete/{reviewerId}")
    // public ResponseEntity<String> deleteReviewByReviewerId(@PathVariable("reviewerId") Long reviewerId) {
    //     try {
    //         reviewRepo.deleteByReviewerId(reviewerId);
    //         return ResponseEntity.ok("Reviews deleted for reviewer with ID: " + reviewerId);
    //     } catch (Exception e) {
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    //     }
    // }
    


    // @DeleteMapping("/delete/{reviewerId}")
    // public ResponseEntity<String> deleteReviewByReviewerId(@PathVariable("reviewerId") Long reviewerId) {
    //            reviewRepo.deleteByReviewerId(reviewerId);
    //         return ResponseEntity.ok("Reviews deleted for reviewer with ID: " + reviewerId);
       
    // }
    






}

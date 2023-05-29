package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Reviewer;
import com.example.demo.Repo.ReviewerRepo;

@RestController
@RequestMapping("/reviewer")
public class ReviewerController {
    @Autowired
    private  ReviewerRepo reviewerRepo;
  
// get all reviewer
    @GetMapping("/getall")
    public List<Reviewer> getAllreviewer(){
        return reviewerRepo.findAll();
    }
    //  get reviwerr by id

@GetMapping ("/find/{id}")
public Optional<Reviewer> getReviewerById(@PathVariable Long id){
    return   reviewerRepo.findById(id);
}

//    save a reviewer

@PostMapping("/post")
public void saveReviewer(@RequestBody Reviewer reviewer){
    reviewerRepo.save(reviewer);
}

//  can delete review by providing reviver id

@DeleteMapping("/delete/{id}")
 public void DeleterReviewer(@PathVariable Long id){
    reviewerRepo.deleteById(id);
 }

}

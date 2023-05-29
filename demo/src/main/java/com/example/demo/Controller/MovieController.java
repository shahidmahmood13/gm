package com.example.demo.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Movie;
import com.example.demo.Repo.MovieRepo;

@RestController
@RequestMapping("/movies")
public class MovieController {

@Autowired
 private  MovieRepo  movieRepo;


 @PostMapping("/post")
 public String postMovie(@RequestBody Movie movie){
    movieRepo.save(movie);

    return  movie.getTitle() + ":" + "saved";
 }


// get all list of movies

@GetMapping("/getall")
public List<Movie> getAllMovies(){
 return movieRepo.findAll();
 }

//  get movie by movie id
 @GetMapping("/{id}")
 public Optional<Movie> getMovie(@PathVariable Long id){
     return movieRepo.findById(id);
 }
//    I can add update the entry for a movie by providing the data listed in Story 1.
    //    so that I can correct errors in previously uploaded movie entries.
 


    @PutMapping("/movies/update/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie updatedMovie, @PathVariable Long id) {
        Optional<Movie> optionalMovie = movieRepo.findById(id);
        if (optionalMovie.isPresent()) {
            Movie existingMovie = optionalMovie.get();
            existingMovie.setTitle(updatedMovie.getTitle());
            existingMovie.setYear(updatedMovie.getYear());
            existingMovie.setGenre(updatedMovie.getGenre());
            existingMovie.setRuntime(updatedMovie.getRuntime());
    
            // Save the updated movie
            Movie savedMovie = movieRepo.save(existingMovie);
            return ResponseEntity.ok(savedMovie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }











 //    I can delete a movie by providing a movie ID
    //    so that I can remove movies I no longer wish to share.
    @DeleteMapping("/Movie/{id}")
    public void deleteMovie(@PathVariable Long id){
       
            movieRepo.deleteById(id);
    }


    public void updatedMovie(MovieRepo movieRepository) {
    }



}
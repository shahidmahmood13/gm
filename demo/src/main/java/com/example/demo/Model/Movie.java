package com.example.demo.Model;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id")
    private Long movieId;
    private String title;
    private Integer year;
    private String genre;
    private String runtime;
    @JsonIgnore
    @OneToMany(mappedBy = "movie" ,cascade =  CascadeType.ALL)
     @Getter @Setter private List<Review> reviews;
    
    public Movie(int movieId, String title, Integer year, String genre, String runtime) {
        this.movieId = (long) movieId;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.runtime = runtime;
    }

    public Movie(long l, String title2, int year2, String genre2, String runtime2) {
    }
    
}

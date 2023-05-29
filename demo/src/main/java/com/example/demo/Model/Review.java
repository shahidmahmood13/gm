package com.example.demo.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
// @Table(name="review")
public class Review {
    
    public static final String Movie = null;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  Long id;
    @ManyToOne
    @JoinColumn(name ="movie_id")
    private Movie movie;
    
    @ManyToOne
@JoinColumn(name = "reviewer_id")
private Reviewer reviewer;

    private String reviewText;
    private Date dateTime;




    
}

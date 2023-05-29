package com.example.demo.Model;

import java.sql.Date;
import java.util.List;

import org.springframework.boot.actuate.autoconfigure.tracing.TracingProperties.Sampling;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

// import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;



@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter

public class Reviewer {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long  id;
private String username;
private String date_join;
private int no_of_review;
@JsonIgnore
@OneToMany(mappedBy = "reviewer", cascade =  CascadeType.ALL)
private List<Review> review;

public Reviewer(Long i, String username, String date_join, int no_of_review) {
    this.id = i;
    this.username = username;
    this.date_join = date_join;
    this.no_of_review = no_of_review;
}
// @JsonProperty(namespace = "reviewsCount",access = JsonProperty.Access.READ_ONLY)
//     public Long getReviewCount(){
//         return Long.valueOf( ((List<Review>) this.review).size() );
//     }


}

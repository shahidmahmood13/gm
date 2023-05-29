package com.example.demo.Repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie ,Long>{

   


}
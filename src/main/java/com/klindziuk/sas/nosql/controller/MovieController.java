//package com.klindziuk.sas.nosql.controller;
//
//import com.klindziuk.sas.nosql.model.Movie;
//import com.klindziuk.sas.nosql.repository.MovieRepository;
//import java.util.List;
//import org.springframework.web.bind.annotation.*;
//
///**
// * @author Jennifer Reif
// */
//@RestController
//@RequestMapping("/movies")
//public class MovieController {
//  private final MovieRepository movieRepository;
//
//  public MovieController(MovieRepository movieRepository) {
//    this.movieRepository = movieRepository;
//  }
//
//  @GetMapping
//  public Iterable<Movie> findAll() {
//    return movieRepository.findAll();
//  }
//
//  @GetMapping("/{title}")
//  public List<Movie> getMovieByTitle(@PathVariable String title) {
//    return movieRepository.getAllMovieByTitle(title);
//  }
//
//  @GetMapping("/search/{title}")
//  public List<Movie> findMovieByTitleLike(@PathVariable String title) {
//    return movieRepository.findAllMovieByTitleLike(title);
//  }
//}

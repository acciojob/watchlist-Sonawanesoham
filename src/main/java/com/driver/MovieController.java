package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    //1
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        String message = movieService.addMovie(movie);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    //2
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        String message = movieService.addDirector(director);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    //3
    @PostMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("mn") String movieName, @RequestParam("dc") String directorName) {
        String message = movieService.addMovieDirectorPair(movieName, directorName);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    //4
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String movieName) {
        Movie movie = movieService.getMovieByName(movieName);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    //5
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String directorName) {
        Director director = movieService.getDirectorByName(directorName);
        return new ResponseEntity<>(director, HttpStatus.OK);
    }

    //6
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String directorName) {
        List<String> list = movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //7
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies() {
        List<String> list = movieService.findAllMovies();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //8
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String directorName) {
        String message = movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    //9
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors() {
        String message = movieService.deleteAllDirectors();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    HashMap<String,Movie> moviedb =new HashMap<>();
    HashMap<String,Director> directordb =new HashMap<>();
    //director vs its movies list hashmap
    HashMap<String, List<String>> movieDirectordb =new HashMap<>();


    public String addMovie(Movie movie) {
        moviedb.put(movie.getName(),movie);
        return "success";
    }

    public String addDirector(Director director) {
        directordb.put(director.getName(),director);
        return "success";
    }

    public String addMovieDirectorPair(String movieName, String directorName) {
        if(!movieDirectordb.containsKey(directorName)){
            movieDirectordb.put(directorName,new ArrayList<String>());
        }
        movieDirectordb.get(directorName).add(movieName);
        return "success";
    }

    public Movie getMovieByName(String movieName) {
        return moviedb.get(movieName);

    }

    public Director getDirectorByName(String directorName) {
        return directordb.get(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName) {
        return  movieDirectordb.get(directorName);
    }

    public List<String> findAllMovies() {
        return new ArrayList<>(moviedb.keySet());
    }

    public String deleteDirectorByName(String directorName) {
        directordb.remove(directorName);
        for(String moviename : movieDirectordb.get(directorName)){
            moviedb.remove(moviename);
        }
        movieDirectordb.remove(directorName);
        return "success";
    }

    public String deleteAllDirectors() {
        for(String dname : directordb.keySet()){
            if(movieDirectordb.containsKey(dname)){
                for(String mname : movieDirectordb.get(dname)){
                    moviedb.remove(mname);
                }
                movieDirectordb.remove(dname);
            }
            directordb.remove(dname);
        }
        return "success";
    }
}
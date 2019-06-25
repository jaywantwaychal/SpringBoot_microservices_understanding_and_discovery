package com.learn.movies.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.movies.models.Movie;

@RestController
@RequestMapping("/movie")
public class MovieResource {

	@RequestMapping("/{movieid}")
	public Movie getMovieDetails(@PathVariable("movieid") String movieid) {
		return new Movie(movieid, "test name");
	}
}

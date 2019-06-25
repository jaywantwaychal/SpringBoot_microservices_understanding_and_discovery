package com.learn.movies.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.movies.models.Rating;
import com.learn.movies.models.UserRatings;

@RestController
@RequestMapping("ratingsdata")
public class MovieRatingResource {

	@RequestMapping("/movies/{movieid}")
	public Rating getMovieRating(@PathVariable("movieid") String movieid) {
		return new Rating(movieid, 3);
	}
	
	@RequestMapping("/users/{userId}")
	public UserRatings getUserRating(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList( new Rating("-jd",78), new
				  Rating("4525", 2));
		
		UserRatings userRatings = new UserRatings();
		userRatings.setRatings(ratings);
		return userRatings;
	}
}

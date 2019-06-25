package com.learn.movies.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.learn.movies.models.CatelogItem;
import com.learn.movies.models.Movie;
import com.learn.movies.models.UserRatings;

@RestController
@RequestMapping("/catelog")
public class MovieCatelogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder builder;
	
	@RequestMapping("/{userid}")
	public List<CatelogItem> getCatelogItems(@PathVariable("userid") String userId) {
		
		/*
		 * List<Rating> ratings = Arrays.asList( new Rating("1234", 4), new
		 * Rating("4525", 2));
		 */
		
		
		UserRatings ratings =  restTemplate.getForObject("http://movie-rating-service/ratingsdata/users/test", UserRatings.class);
		return ratings.getRatings().stream().map(rating -> {
			//Movie movie = restTemplate.getForObject("http://localhost:8082/movie/"+rating.getMovieid(), Movie.class);
			
			
			/*
			 * List<HttpMessageConverter<?>> messageConverters = new
			 * ArrayList<HttpMessageConverter<?>>(); //Add the Jackson Message converter
			 * MappingJackson2HttpMessageConverter converter = new
			 * MappingJackson2HttpMessageConverter();
			 * 
			 * // Note: here we are making this converter to process any kind of response,
			 * // not only application/*json, which is the default behaviour
			 */			/*
			 * converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
			 * messageConverters.add(converter);
			 * restTemplate.setMessageConverters(messageConverters);
			 */
			
		//	Object object = restTemplate.getForObject("http://openlibrary.org/search.json?q=the+lord+of+the+rings", Object.class);
			
			
			Movie movie =  builder.build()
			.get()
			.uri("http://movie-info-service/movie/"+rating.getMovieid())
			.retrieve()
			.bodyToMono(Movie.class)
			.block();
			return new CatelogItem("name", "new Description", rating.getRating());
		}).collect(Collectors.toList());
	}
}

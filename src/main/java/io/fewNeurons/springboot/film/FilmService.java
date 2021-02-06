package io.fewNeurons.springboot.film;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Service
public class FilmService {

	private List<Film> films = new ArrayList<>(Arrays.asList(
			new Film("2341oi1","Ficción Pulposa", new Date()),
			new Film("4234ki2","Lustrillo", new Date()),
			new Film("8714le5","Collons q bobos", new Date())
			));
	
	private String url = "https://api.themoviedb.org/3/movie/550?api_key=6e9e2f3ab49e2b1cdf0d0850f03e048f";
	private String urlM = "https://api.themoviedb.org/3/movie/top_rated?api_key=6e9e2f3ab49e2b1cdf0d0850f03e048f&language=en-US&page=1";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/films")
	public Object[] getAllFilms() {
		return restTemplate.getForObject(urlM, Object[].class);
	}
}







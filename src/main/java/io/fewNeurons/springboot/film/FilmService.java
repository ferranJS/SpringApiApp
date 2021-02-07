package io.fewNeurons.springboot.film;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;

@Service
public class FilmService {

	private String url = "https://api.themoviedb.org/3/movie/550?api_key=6e9e2f3ab49e2b1cdf0d0850f03e048f";
	private String urlM = "https://api.themoviedb.org/3/movie/top_rated?api_key=6e9e2f3ab49e2b1cdf0d0850f03e048f&language=en-US&page=1";
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Film> getAllFilms() {
		String jsonString = restTemplate.getForEntity(urlM, String.class).getBody();
		List<Film> films = new ArrayList<Film>();
		
		JSONObject jsono = new JSONObject(jsonString);
		
		JSONArray results = jsono.getJSONArray("results");
		
		for(int i=0; i<results.length(); i++) {
			JSONObject jsonFilm = results.getJSONObject(i);
			
			String id = Integer.toString(jsonFilm.getInt("id"));
			String title = jsonFilm.getString("title");
			String date = jsonFilm.getString("release_date");
			String language = jsonFilm.getString("original_language");
			String description = jsonFilm.getString("overview");
			int vote_count = jsonFilm.getInt("vote_count");
			double vote_average = jsonFilm.getDouble("vote_average");
			
			Film film = new Film(id, title, date, description, language, vote_count, vote_average);
			films.add(film);
		}
		return films;
	}
	
	public ResponseEntity<String> getFilmById(String id) {
		//restTemplate.getForObject(urlM, Object[].class);
		
		ResponseEntity<String> response
		  = restTemplate.getForEntity(urlM, String.class);
		
		return restTemplate.getForEntity(urlM, String.class);
	}
}







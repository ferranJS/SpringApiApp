package io.fewNeurons.springboot.film;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class FilmService {

	private String key = "6e9e2f3ab49e2b1cdf0d0850f03e048f";
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Film> getFilmList(String url) {
		String jsonString = restTemplate.getForEntity(url, String.class).getBody();
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
	
	//Devuelve una lista con las películas mejor puntuadas al controller
	public List<Film> getTopFilms(String lang, int pag) {
		String url = "https://api.themoviedb.org/3/movie/top_rated?api_key="+key+"&language="+lang+"&page="+pag;
		
		return getFilmList(url);
	}
	
	//Devuelve una lista con las próximas películas ya anunciadas al controller
	public List<Film> getUpcomingFilms(String lang, int pag) {
		String url = "https://api.themoviedb.org/3/movie/upcoming?api_key="+key+"&language="+lang+"&page="+pag;

		return getFilmList(url);
	}
	
	//Devuelve una lista con las películas en cartelera al controller
	public List<Film> getFilmsInTheatres(String lang, int pag) {
		String url = "https://api.themoviedb.org/3/movie/now_playing?api_key="+key+"&language="+lang+"&page="+pag;

		return getFilmList(url);
	}
	
	//Devuelve una lista con películas similares a la actual al controller
	public List<Film> getSimilarFilms(String id, String lang, int pag) {
		String url = "https://api.themoviedb.org/3/movie/"+id+"/similar?api_key="+key+"&language="+lang+"&page="+pag;

		return getFilmList(url);
	}
	//Devuelve una película según la id al controller al controller
	public Film getFilmById(String id, String lang, int pag) {
		String url = "https://api.themoviedb.org/3/movie/"+id+"?api_key="+key+"&language="+lang;
		String jsonString = restTemplate.getForEntity(url, String.class).getBody();
		
		JSONObject jsonFilm = new JSONObject(jsonString);
		
		String title = jsonFilm.getString("title");
		String date = jsonFilm.getString("release_date");
		String language = jsonFilm.getString("original_language");
		String description = jsonFilm.getString("overview");
		int vote_count = jsonFilm.getInt("vote_count");
		double vote_average = jsonFilm.getDouble("vote_average");
		
		Film film = new Film(id, title, date, description, language, vote_count, vote_average);
		
		return film;
	}
}







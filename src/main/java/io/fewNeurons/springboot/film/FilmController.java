package io.fewNeurons.springboot.film;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FilmController {
	
	@Autowired
	private FilmService filmService; 
	
	@RequestMapping("/films")
	public List<Object> getAllFilms() {
		return filmService.getAllFilms();
	}
	
	@RequestMapping("/films/{id}")
	public List<Object> getFilmById(@PathVariable String id) {
		return filmService.getAllFilms();
	}
	
	
}





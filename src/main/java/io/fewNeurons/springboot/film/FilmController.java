package io.fewNeurons.springboot.film;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FilmController {
	
	@Autowired
	private FilmService filmService; 
	
	@RequestMapping(value="/films", method=RequestMethod.GET)
	public ResponseEntity<String> getAllFilms() {
		return filmService.getAllFilms();
	}
	
	@RequestMapping(value="/films/{id}", method=RequestMethod.GET)
	public ResponseEntity<String> getFilmById(@PathVariable String id) {
		return filmService.getFilmById(id);
	}
}
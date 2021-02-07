package io.fewNeurons.springboot.film;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FilmController {
	
	@Autowired
	private FilmService filmService; 
	
	@RequestMapping(value="/films", method=RequestMethod.GET)
	@ResponseBody
	public List<Film> getAllFilms() {
		return filmService.getAllFilms();
	}
	
	@RequestMapping(value="/films/{id}", method=RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public ResponseEntity<String> getFilmById(@PathVariable String id) {
		return filmService.getFilmById(id);
	}
}
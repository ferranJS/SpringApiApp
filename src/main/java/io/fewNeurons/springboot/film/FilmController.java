package io.fewNeurons.springboot.film;

import java.util.Arrays; 
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FilmController {

	@Autowired
	private FilmService filmService;
	
	@RequestMapping("/films")
	public List<Film> getAllFilms() {
		//List<Film> films = new List()
		return filmService.getAllFilms();
	}
}





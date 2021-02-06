package io.fewNeurons.springboot.film;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmController {

	@RequestMapping("/films")
	public List<Film> getAllFilms() {
		//List<Film> films = new List()
		return Arrays.asList(
				new Film("2341oi1","Ficción Pulposa", new Date()),
				new Film("4234ki2","Lustrillo", new Date()),
				new Film("8714le5","Collons q bobos", new Date())
				);
	}
}

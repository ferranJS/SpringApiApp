package io.fewNeurons.springboot.film;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FilmService {

	private List<Film> films = Arrays.asList(
			new Film("2341oi1","Ficción Pulposa", new Date()),
			new Film("4234ki2","Lustrillo", new Date()),
			new Film("8714le5","Collons q bobos", new Date())
			);
	
	public List<Film> getAllFilms() {
		return films;
	}
}







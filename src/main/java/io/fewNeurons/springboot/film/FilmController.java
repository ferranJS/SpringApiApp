package io.fewNeurons.springboot.film;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FilmController {
	
	@Autowired
	private FilmService filmService; 
	
	@GetMapping(value="/films/top")
	public List<Film> getTopFilms(@RequestParam(required=false, name="lang") String lang,
									@RequestParam(required=false, name="pag") Integer pag) {
		String langc = "es-ES";
		int pagc = 1;
		try {
			langc = lang;
			pagc = pag;
		} catch(Exception e) { langc = "es-ES"; pagc = 1;}
		return filmService.getTopFilms(langc, pagc);
	}
	
	@GetMapping(value="/films/upcoming")
	public List<Film> getUpcomingFilms(@RequestParam(required=false, name="lang") String lang,
			  							@RequestParam(required=false, name="pag") Integer pag) {
		String langc = "es-ES";
		int pagc = 1;
		try {
			langc = lang;
			pagc = pag;
		} catch(Exception e) { langc = "es-ES";}
		
		return filmService.getUpcomingFilms(langc, pagc);
	}
	
	@GetMapping(value="/films/in_theatres/")
	public List<Film> getFilmsInTheatres(@RequestParam(required=false, name="lang") String lang,
										  @RequestParam(required=false, name="pag") Integer pag) {
		String langc = "es-ES";
		int pagc = 1;
		try {
			langc = lang;
			pagc = pag;
		} catch(Exception e) { langc = "es-ES"; pagc = 1;}
		return filmService.getFilmsInTheatres(langc, pagc);
	}

	@GetMapping(value="/film/{id}")
	public Film getFilmById(@PathVariable String id,
							@RequestParam(required=false, name="lang") String lang,
							  @RequestParam(required=false, name="pag") Integer pag) {
		String langc = "es-ES";
		int pagc = 1;
		try {
			langc = lang;
			pagc = pag;
		} catch(Exception e) { langc = "es-ES"; pagc = 1;}
		return filmService.getFilmById(id, langc, pagc);
	}
	
	@GetMapping(value="/film/{id}/similar_films")
	public List<Film> getSimilarFilms(@PathVariable String id,
										@RequestParam(required=false, name="lang") String lang,
										  @RequestParam(required=false, name="pag") Integer pag) {
		String langc = "es-ES";
		int pagc = 1;
		try {
			langc = lang;
			pagc = pag;
		} catch(Exception e) { langc = "es-ES"; pagc = 1;}
		return filmService.getSimilarFilms(id, langc, pagc);
	}
}

package io.fewNeurons.springboot.film;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//CORS configurado para que acepte cualquier llamada HTTP, por lo tanto, llamadas XMLHTTPRequest 
@RestController
@RequestMapping(value="/films", method = RequestMethod.GET)
public class FilmController {
	
	@Autowired
	private FilmService filmService; 
	
	//Devuelve una lista con las películas mejor puntuadas
	@GetMapping(value="/top")
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4202", allowedHeaders = "*")
	public List<Film> getTopFilms(@RequestParam(required=false, name="lang", defaultValue="es-ES") String lang,
									@RequestParam(required=false, name="pag", defaultValue="1") Integer pag) {
		
		return filmService.getTopFilms(lang, pag);
	}
	
	//Devuelve una lista con las próximas películas ya anunciadas
	@GetMapping(value="/upcoming")
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4202", allowedHeaders = "*")
	public List<Film> getUpcomingFilms(@RequestParam(required=false, name="lang", defaultValue="es-ES") String lang,
			  							@RequestParam(required=false, name="pag", defaultValue="1") Integer pag) {
		
		return filmService.getUpcomingFilms(lang, pag);
	}
	
	//Devuelve una lista con las películas en cartelera
	@GetMapping(value="/in_theatres")	
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4202", allowedHeaders = "*")
	public List<Film> getFilmsInTheatres(@RequestParam(required=false, name="lang", defaultValue="es-ES") String lang,
										  @RequestParam(required=false, name="pag", defaultValue="1") Integer pag) {

		return filmService.getFilmsInTheatres(lang, pag);
	}

	//Devuelve una película según la id
	@GetMapping(value="/{id}")
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4202", allowedHeaders = "*")
	public Film getFilmById(@PathVariable String id,
							@RequestParam(required=false, name="lang", defaultValue="es-ES") String lang,
							  @RequestParam(required=false, name="pag", defaultValue="1") Integer pag) {

		return filmService.getFilmById(id, lang, pag);
	}
	
	//Devuelve una lista con películas similares a la actual
	@GetMapping(value="/{id}/similar_films")
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4202", allowedHeaders = "*")
	public List<Film> getSimilarFilms(@PathVariable String id,
										@RequestParam(required=false, name="lang", defaultValue="es-ES") String lang,
										  @RequestParam(required=false, name="pag", defaultValue="1") Integer pag) {
	
		return filmService.getSimilarFilms(id, lang, pag);
	}
}

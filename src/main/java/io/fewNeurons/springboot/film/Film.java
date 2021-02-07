package io.fewNeurons.springboot.film;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Film {

	private String id;
	private String title;
	private String description;
	private String release_String;
	private String genre;
	private String original_language;
	private int vote_count;
	private double vote_average;
	
	public Film() {}
	
	public Film(String id, String title, String release_String, String description, String original_language, int vote_count,
			double vote_average) {
		this.id = id;
		this.title = title;
		this.release_String = release_String;
		this.description = description;
		this.original_language = original_language;
		this.vote_count = vote_count;
		this.vote_average = vote_average;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getString() {
		return release_String;
	}
	public void setString(String String) {
		this.release_String = String;
	}

	public String getRelease_String() {
		return release_String;
	}

	public void setRelease_String(String release_String) {
		this.release_String = release_String;
	}

	public String getOriginal_language() {
		return original_language;
	}

	public void setOriginal_language(String original_language) {
		this.original_language = original_language;
	}

	public int getVote_count() {
		return vote_count;
	}

	public void setVote_count(int vote_count) {
		this.vote_count = vote_count;
	}

	public double getVote_average() {
		return vote_average;
	}

	public void setVote_average(double vote_average) {
		this.vote_average = vote_average;
	}
	
	
}

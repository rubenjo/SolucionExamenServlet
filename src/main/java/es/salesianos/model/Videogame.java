package es.salesianos.model;

import java.util.Date;

public class Videogame implements IEntity<String>{

	private String tittle;
	private String recommendedAge;
	private Date releaseDate;
	private String consoleName;
	
	public String getTittle() {
		return tittle;
	}
	
	public void setTittle(String titulo) {
		this.tittle = titulo;
	}
	
	public String getRecommendedAge() {
		return recommendedAge;
	}
	
	public void setRecommendedAge(String recommendedAge) {
		this.recommendedAge = recommendedAge;
	}
	
	public Date getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public String getConsoleName() {
		return consoleName;
	}
	
	public void setConsoleName(String consoleName) {
		this.consoleName = consoleName;
	}

	public String getId() {
		return getTittle();
	}

	public void setId(String id) {
		setTittle(id);
	}
	
}

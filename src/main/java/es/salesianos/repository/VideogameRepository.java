package es.salesianos.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import es.salesianos.model.Videogame;

@Repository
public class VideogameRepository {

	private static final String INSERT = "INSERT INTO VIDEOGAME (tittle,recommendedAge,releaseDate,consoleName) VALUES ( :tittle, :recommendedAge, :releaseDate, :consoleName)";
	private static final String DELETE = "DELETE FROM VIDEOGAME WHERE tittle = ?";
	private static final String SELECT = "SELECT * FROM VIDEOGAME";

	@Autowired
	private JdbcTemplate template;

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	public void insert(Videogame videogame) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("tittle", videogame.getTittle());
		params.addValue("recommendedAge", videogame.getRecommendedAge());
		params.addValue("releaseDate", videogame.getReleaseDate());
		params.addValue("consoleName", videogame.getConsoleName());
		namedJdbcTemplate.update(INSERT, params);
	}

	public void delete(String tittle) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("tittle", tittle);
		namedJdbcTemplate.update(DELETE, params);
	}

	public List<Videogame> listAllVideogames() {
		List<Videogame> videogames = template.query(SELECT, new BeanPropertyRowMapper<Videogame>(Videogame.class));
		return videogames;
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public NamedParameterJdbcTemplate getNamedJdbcTemplate() {
		return namedJdbcTemplate;
	}

	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}
}

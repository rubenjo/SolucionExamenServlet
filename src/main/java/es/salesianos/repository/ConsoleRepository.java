package es.salesianos.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import es.salesianos.model.Console;

public class ConsoleRepository {

	private static final String INSERT = "INSERT INTO CONSOLE (name,company)" + "VALUES ( :name, :company)";
	private static final String DELETE = "DELETE FROM CONSOLE WHERE name = :name";
	private static final String SELECT = "SELECT * FROM CONSOLE";
	private static final String SELECTBYCOMPANY = "SELECT * FROM CONSOLE WHERE company = :name";
	
	@Autowired
	private JdbcTemplate template;
	
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public void insert(Console consoleForm) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", consoleForm.getName());
		params.addValue("companyId", consoleForm.getCompany());
		namedJdbcTemplate.update(INSERT, params);
	}
	
	public void delete(String name) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", name);
		namedJdbcTemplate.update(DELETE, params);
	}

	public List<Console> listAllConsoles() {
		List<Console> consoles = template.query(SELECT, new BeanPropertyRowMapper(Console.class));
		return consoles;
	}

	public List<Console> listAllByCompany(int idCompany){
		List<Console> consoles = new ArrayList<Console>();
		List<Map<String, Object>> rows = namedJdbcTemplate.queryForList(SELECTBYCOMPANY, new MapSqlParameterSource("id", String.valueOf(idCompany)));		
			for(Map row : rows){
				Console console = new Console();
				console.setName((String)(row.get("name")));
				console.setCompany((String)(row.get("company")));
				consoles.add(console);
			}
		return consoles;	
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

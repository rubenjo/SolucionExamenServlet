package es.salesianos.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import es.salesianos.model.Company;

public class CompanyRepository {

	private static final String INSERT = "INSERT INTO COMPANY (name,dateCreation)" + "VALUES (:name, :dateCreation)";
	private static final String DELETE = "DELETE FROM COMPANY WHERE name = :name";
	private static final String SELECT = "SELECT * FROM COMPANY";
	
	@Autowired
	private JdbcTemplate template;
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public void insert(Company companyForm) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", companyForm.getName());
		params.addValue("dateCreation", companyForm.getDateCreation());
		namedJdbcTemplate.update(INSERT, params);
	}

	public void delete(String name) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", name);
		namedJdbcTemplate.update(DELETE, params);
	}


	public List<Company> listAllCompanies() {
		List<Company> companies = template.query(SELECT, new BeanPropertyRowMapper(Company.class));
		return companies;
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

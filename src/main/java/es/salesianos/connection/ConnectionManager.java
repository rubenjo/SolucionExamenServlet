package es.salesianos.connection;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import es.salesianos.model.Console;

public interface ConnectionManager {

	public Connection open(String jdbcUrl);

	public void close(Connection conn);

	void insert(Console consola);

	Optional<Console> search(Console consola);

	void update(Console consola);

	List<Console> listAllConsoles();
}

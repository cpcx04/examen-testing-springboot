package com.salesianostriana.dam.testing.examen;

import com.salesianostriana.dam.testing.examen.model.DatoMeteorologico;
import com.salesianostriana.dam.testing.examen.model.DatoMeterologicoPK;
import com.salesianostriana.dam.testing.examen.repo.DatoMeteorologicoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles({"dev"})
//@Sql(value = "classpath:import-test.sql",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
//@Sql(value = "classpath:delete-test.sql" , executionPhase = Sql.ExecutionPhase.AFTER_TEST_CLASS)
@Testcontainers
class RepositoryTestTemplate {


	@Autowired
	private DatoMeteorologicoRepository repository;
	@Container
	@ServiceConnection
	static PostgreSQLContainer postgres = new PostgreSQLContainer(DockerImageName.parse("postgres:16-alpine"))
			.withUsername("testUser")
			.withPassword("testSecret")
			.withDatabaseName("testDatabase");

	@Test
	void test() {
		LocalDate fecha = LocalDate.of(2019,12,11);
		DatoMeterologicoPK pk1 = new DatoMeterologicoPK("Sevilla",fecha);

		DatoMeteorologico d1 = DatoMeteorologico.builder()
				.precipitacion(200)
				.id(pk1)
				.build();

		List<DatoMeteorologico> datos = repository.buscarPorPoblacion("Sevilla");
		List<DatoMeteorologico> datosVacio = repository.buscarPorPoblacion("Pernanbuco de la Sierra");

		assertTrue(datosVacio.isEmpty());
		//assertTrue(datos.isEmpty());
	}

}

package com.softtek.gestionhrapi.cantidatos;

import java.math.BigDecimal;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.softtek.exception.GestionHrException;
import com.softtek.gestionhrapi.dominio.Candidatos;
import com.softtek.gestionhrapi.implementacion.CandidatosDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/applicationContext*.xml" })
public class TestUpdateNulls {

	@Autowired
	CandidatosDAO candidatoDAO;

	private Candidatos candidato;

	@Before
	public void init() throws GestionHrException {
		candidato = candidatoDAO.readCandidato(new BigDecimal(36));
	}

	/**
	 * Espera una excepción al introducir un nulo en NOMBRE.
	 */
	@Test(expected = GestionHrException.class)
	public void testNombreNull() throws GestionHrException {
		candidato.setNombre(null);
		candidatoDAO.updateCandidato(candidato);
	}
	
	/**
	 * Espera una excepción al introducir un nulo en PROVINCIA.
	 */
	@Test(expected = GestionHrException.class)
	public void testProvinciaNull() throws GestionHrException {
		candidato.setProvincia(null);
		candidatoDAO.updateCandidato(candidato);
	}
	
	/**
	 * Espera una excepción al introducir un nulo en PERFIL.
	 */
	@Test(expected = GestionHrException.class)
	public void testPerfilNull() throws GestionHrException {
		candidato.setPerfil(null);
		candidatoDAO.updateCandidato(candidato);
	}
	
	/**
	 * Espera una excepción al introducir un nulo en EXPECT_CONTRACTUAL.
	 */
	@Test(expected = GestionHrException.class)
	public void testExpectContractualNull() throws GestionHrException {
		candidato.setExpectContractual(null);
		candidatoDAO.updateCandidato(candidato);
	}
	
	/**
	 * Espera una excepción al introducir un nulo en EXPECT_ECONOMICA.
	 */
	@Test(expected = GestionHrException.class)
	public void testExpectEconomicaNull() throws GestionHrException {
		candidato.setExpectEconomica(null);
		candidatoDAO.updateCandidato(candidato);
	}
	
	/**
	 * Espera una excepción al introducir un nulo en FEEDBACK_SOURCING.
	 */
	@Test(expected = GestionHrException.class)
	public void testFeedbackSourcingNull() throws GestionHrException {
		candidato.setFeedbackSourcing(null);
		candidatoDAO.updateCandidato(candidato);
	}
	
	/**
	 * Espera una excepción al introducir un nulo en TECNICO_SELECCION.
	 */
	@Test(expected = GestionHrException.class)
	public void testTecnicoSeleccionNull() throws GestionHrException {
		candidato.setTecnicoSeleccion(null);
		candidatoDAO.updateCandidato(candidato);
	}
}
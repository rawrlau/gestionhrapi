package com.softtek.gestionhrapi.cantidatos;

import java.math.BigDecimal;

import junit.framework.Assert;

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
public class TestCreate {

	@Autowired
	CandidatosDAO candidatoDAO;

	/**
	 * Se comprueba que el alta de candidato ha sido realizada.
	 */
	@Test
	public void testAltaCandidatoOk() throws GestionHrException {

		long antes = Candidatos.countCandidatoses();
		System.out.println("N�mero de candidatos ANTES: " + antes);

		Candidatos candidatoAlta = candidatoInit();
		candidatoDAO.createCandidato(candidatoAlta);

		long despues = Candidatos.countCandidatoses();
		System.out.println("N�mero de candidatos DESPU�S: " + despues);

		Assert.assertEquals(antes + 1, despues);
	}

	/**
	 * Esperamos excepci�n si el candidato es nulo.
	 * 
	 * @throws GestionHrException
	 */
	@Test(expected = GestionHrException.class)
	public void testAltaCandidatoNull() throws GestionHrException {
		candidatoDAO.createCandidato(null);
	}

	/**
	 * Esperamos excepci�n si nombre es nulo.
	 * 
	 * @throws GestionHrException
	 */
	@Test(expected = GestionHrException.class)
	public void testAltaCandidatoNombreNull() throws GestionHrException {
		Candidatos candidatoAlta = candidatoInit();
		candidatoAlta.setNombre(null);
		candidatoDAO.createCandidato(candidatoAlta);
	}

	/**
	 * Esperamos excepci�n si provincia es nulo.
	 * 
	 * @throws GestionHrException
	 */
	@Test(expected = GestionHrException.class)
	public void testAltaCandidatoProvinciaNull() throws GestionHrException {
		Candidatos candidatoAlta = candidatoInit();
		candidatoAlta.setProvincia(null);
		candidatoDAO.createCandidato(candidatoAlta);
	}

	/**
	 * Esperamos excepci�n si perfil es nulo.
	 * 
	 * @throws GestionHrException
	 */
	@Test(expected = GestionHrException.class)
	public void testAltaCandidatoPerfilNull() throws GestionHrException {
		Candidatos candidatoAlta = candidatoInit();
		candidatoAlta.setPerfil(null);
		candidatoDAO.createCandidato(candidatoAlta);
	}

	/**
	 * Esperamos excepci�n si expectContractual es nulo.
	 * 
	 * @throws GestionHrException
	 */
	@Test(expected = GestionHrException.class)
	public void testAltaCandidatoExpectContractualNull() throws GestionHrException {
		Candidatos candidatoAlta = candidatoInit();
		candidatoAlta.setExpectContractual(null);
		candidatoDAO.createCandidato(candidatoAlta);
	}

	/**
	 * Esperamos excepci�n si expectEconomica es nulo.
	 * 
	 * @throws GestionHrException
	 */
	@Test(expected = GestionHrException.class)
	public void testAltaCandidatoExpectEconomicaNull() throws GestionHrException {
		Candidatos candidatoAlta = candidatoInit();
		candidatoAlta.setExpectEconomica(null);
		candidatoDAO.createCandidato(candidatoAlta);
	}

	/**
	 * Esperamos excepci�n si feedbackSourcing es nulo.
	 * 
	 * @throws GestionHrException
	 */
	@Test(expected = GestionHrException.class)
	public void testAltaCandidatoFeedbackSourcingNull() throws GestionHrException {
		Candidatos candidatoAlta = candidatoInit();
		candidatoAlta.setFeedbackSourcing(null);
		candidatoDAO.createCandidato(candidatoAlta);
	}

	/**
	 * Esperamos excepci�n si tecnicoSeleccion es nulo.
	 * 
	 * @throws GestionHrException
	 */
	@Test(expected = GestionHrException.class)
	public void testAltaCandidatoTecnicoSeleccionNull() throws GestionHrException {
		Candidatos candidatoAlta = candidatoInit();
		candidatoAlta.setTecnicoSeleccion(null);
		candidatoDAO.createCandidato(candidatoAlta);
	}

	/**
	 * Esperamos una expcepci�n al dar de alta un candidato con varios de sus
	 * atributos nulos.
	 * 
	 * @throws GestionHrException
	 */
	@Test(expected = GestionHrException.class)
	public void testAltaCandidatoVariosNull() throws GestionHrException {
		Candidatos candidatoAlta = candidatoInit();
		candidatoAlta.setNombre(null);
		candidatoAlta.setPerfil(null);
		candidatoAlta.setFeedbackSourcing(null);
		candidatoDAO.createCandidato(candidatoAlta);
	}

	/**
	 * Devuelve un candidato con los atributos not null Se usa para inicializar
	 * un candidato r�pidamente.
	 * 
	 * @return
	 */
	private Candidatos candidatoInit() {
		Candidatos candidatoP = new Candidatos();
		candidatoP.setNombre("Gollum");
		candidatoP.setProvincia("Misty Mountain");
		candidatoP.setPerfil("Hobbit");
		candidatoP.setExpectContractual("Encontrar el anillo");
		candidatoP.setExpectEconomica(new BigDecimal(2));
		candidatoP.setFeedbackSourcing("FS");
		candidatoP.setTecnicoSeleccion("TS");
		return candidatoP;
	}
}
package com.softtek.gestionhrapi;

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
public class TestCandidatosAlta {

	@Autowired
	CandidatosDAO candidato;

	/**
	 * Se comprueba que el alta de candidato ha sido realizada.
	 */
	@Test
	public void testAltaCandidatoOk() throws GestionHrException {

		long antes = Candidatos.countCandidatoses();
		System.out.println("Número de candidatos ANTES: " + antes);

		Candidatos candidatoAlta = candidatoInit();
		candidato.createCandidato(candidatoAlta);

		long despues = Candidatos.countCandidatoses();
		System.out.println("Número de candidatos DESPUÉS: " + despues);

		Assert.assertEquals(antes + 1, despues);
	}

	/**
	 * Esperamos excepción si el candidato es nulo.
	 * 
	 * @throws GestionHrException
	 */
	@Test(expected = GestionHrException.class)
	public void testAltaCandidatoNull() throws GestionHrException {
		candidato.createCandidato(null);
	}

	/**
	 * Esperamos excepción si nombre es nulo.
	 * 
	 * @throws GestionHrException
	 */
	@Test(expected = GestionHrException.class)
	public void testAltaCandidatoNombreNull() throws GestionHrException {
		Candidatos candidatoAlta = candidatoInit();
		candidatoAlta.setNombre(null);
		candidato.createCandidato(candidatoAlta);
	}

	/**
	 * Esperamos excepción si provincia es nulo.
	 * 
	 * @throws GestionHrException
	 */
	@Test(expected = GestionHrException.class)
	public void testAltaCandidatoProvinciaNull() throws GestionHrException {
		Candidatos candidatoAlta = candidatoInit();
		candidatoAlta.setProvincia(null);
		candidato.createCandidato(candidatoAlta);
	}

	/**
	 * Esperamos excepción si perfil es nulo.
	 * 
	 * @throws GestionHrException
	 */
	@Test(expected = GestionHrException.class)
	public void testAltaCandidatoPerfilNull() throws GestionHrException {
		Candidatos candidatoAlta = candidatoInit();
		candidatoAlta.setPerfil(null);
		candidato.createCandidato(candidatoAlta);
	}

	/**
	 * Esperamos excepción si expectContractual es nulo.
	 * 
	 * @throws GestionHrException
	 */
	@Test(expected = GestionHrException.class)
	public void testAltaCandidatoExpectContractualNull()
			throws GestionHrException {
		Candidatos candidatoAlta = candidatoInit();
		candidatoAlta.setExpectContractual(null);
		candidato.createCandidato(candidatoAlta);
	}

	/**
	 * Esperamos excepción si expectEconomica es nulo.
	 * 
	 * @throws GestionHrException
	 */
	@Test(expected = GestionHrException.class)
	public void testAltaCandidatoExpectEconomicaNull()
			throws GestionHrException {
		Candidatos candidatoAlta = candidatoInit();
		candidatoAlta.setExpectEconomica(null);
		candidato.createCandidato(candidatoAlta);
	}

	/**
	 * Esperamos excepción si feedbackSourcing es nulo.
	 * 
	 * @throws GestionHrException
	 */
	@Test(expected = GestionHrException.class)
	public void testAltaCandidatoFeedbackSourcingNull()
			throws GestionHrException {
		Candidatos candidatoAlta = candidatoInit();
		candidatoAlta.setFeedbackSourcing(null);
		candidato.createCandidato(candidatoAlta);
	}

	/**
	 * Esperamos excepción si tecnicoSeleccion es nulo.
	 * 
	 * @throws GestionHrException
	 */
	@Test(expected = GestionHrException.class)
	public void testAltaCandidatoTecnicoSeleccionNull()
			throws GestionHrException {
		Candidatos candidatoAlta = candidatoInit();
		candidatoAlta.setTecnicoSeleccion(null);
		candidato.createCandidato(candidatoAlta);
	}

	/**
	 * Esperamos una expcepción al dar de alta un candidato con varios de sus
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
		candidato.createCandidato(candidatoAlta);
	}

	/**
	 * Devuelve un candidato con los atributos not null Se usa para inicializar
	 * un candidato rápidamente.
	 * 
	 * @return
	 */
	private Candidatos candidatoInit() {
		Candidatos candidatoP = new Candidatos();
		candidatoP.setNombre("Gandalf");
		candidatoP.setProvincia("Tierra Media");
		candidatoP.setPerfil("Mago");
		candidatoP.setExpectContractual("Ser el boss");
		candidatoP.setExpectEconomica(new BigDecimal(99999999));
		candidatoP.setFeedbackSourcing("FS");
		candidatoP.setTecnicoSeleccion("TS");
		return candidatoP;
	}
}
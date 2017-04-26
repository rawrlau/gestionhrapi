package com.softtek.gestionhrapi;

import java.math.BigDecimal;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.softtek.exception.GestionHrException;
import com.softtek.gestionhrapi.dominio.Candidatos;
import com.softtek.gestionhrapi.dominio.CandidatosDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/applicationContext*.xml" })
public class TestCandidatosBaja {

	@Autowired
	CandidatosDAO candidato;

	/**
	 * Se comprueba que la baja de candidato ha sido realizada.
	 */
	@Test
	public void testBajaCandidatoOk() throws GestionHrException {

		long antes = Candidatos.countCandidatoses();
		System.out.println("Número de candidatos ANTES: " + antes);
		

		List<Candidatos> lista = Candidatos.findAllCandidatoses();
		for (Candidatos candidato : lista) {
			System.out.println(candidato.toString());
		}
		
		candidato.deleteCandidato(new BigDecimal(22));

		long despues = Candidatos.countCandidatoses();
		System.out.println("Número de candidatos DESPUÉS: " + despues);

		Assert.assertEquals(antes - 1, despues);
	}

	/**
	 * Esperamos excepción si la id de candidato no existe.
	 * 
	 * @throws GestionHrException
	 */
	@Test(expected = GestionHrException.class)
	public void testBajaCandidatoIdNoExistente() throws GestionHrException {
		
		Candidatos candidato = this.candidato.readCandidato(new BigDecimal(99999));
		this.candidato.deleteCandidato(candidato.getIdCandidato());
	}
	
	
}
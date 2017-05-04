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
public class TestRead {

	@Autowired
	CandidatosDAO candidatoDAO;

	@Test
	public void testConsultaCandidatoOk() throws GestionHrException {
		Candidatos candidato = candidatoDAO.readCandidato(new BigDecimal(101));
		System.out.println(candidato.toString());
		Assert.assertNotNull(candidato);
	}

	@Test(expected = GestionHrException.class)
	public void testConsultaCandidatoIdNull() throws GestionHrException {
		Candidatos candidato = candidatoDAO.readCandidato(null);
	}

	@Test
	public void testReadAllCandidatos() throws GestionHrException {
		Assert.assertEquals(candidatoDAO.readAllCandidatos().size(), Candidatos.countCandidatoses());
	}

	@Test
	public void testReadAllCandidatosLimit() throws GestionHrException {
		Assert.assertEquals(candidatoDAO.readAllCandidatos(3).size(), 3);
	}
}
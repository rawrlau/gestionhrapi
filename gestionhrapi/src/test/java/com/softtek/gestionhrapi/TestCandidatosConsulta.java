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
import com.softtek.gestionhrapi.dominio.CandidatosDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/applicationContext*.xml" })
public class TestCandidatosConsulta {

	@Autowired
	CandidatosDAO candidato;

	@Test
	public void testConsultaCandidato() throws GestionHrException {

		Candidatos candidato = this.candidato.readCandidato(new BigDecimal(19));
		System.out.println(candidato.toString());

		Assert.assertNotNull(candidato);
	}

	@Test(expected = GestionHrException.class)
	public void testConsultaIdCandidatoNull() throws GestionHrException {

		Candidatos candidato = this.candidato.readCandidato(null);

	}
}
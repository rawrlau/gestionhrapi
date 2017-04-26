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
public class TestCandidatosModificacion {

	@Autowired
	CandidatosDAO candidato;

	@Test
	public void testModificacionCandidato() throws GestionHrException {

		Candidatos candidatoMod = candidato.readCandidato(new BigDecimal(35));
		candidatoMod.setApellidos("El Gris");

		candidato.updateCandidato(candidatoMod);

		Assert.assertEquals(candidatoMod.getApellidos(), "El Gris");
	}

}
package com.softtek.gestionhrapi;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.softtek.gestionhrapi.dominio.IdiomasCandidato;
import com.softtek.gestionhrapi.dominio.exception.GestionHrException;
import com.softtek.gestionhrapi.dominio.interfaces.IdiomaImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/applicationContext*.xml" })
public class TestIdiomas {
	@Autowired
	IdiomaImpl idiomas;

	@Test
	public void testAltaIdiomas() throws GestionHrException {
		idiomas.altaIdioma("Ingles", new BigDecimal(99), "Bajo", "B1");
		assertNotNull(idiomas);
	}

	public void testBajaIdiomas() throws GestionHrException {
		idiomas.bajaIdioma("Ingles", new BigDecimal(98), "Bajo", "B1");
		assertNotNull(idiomas);
	}

	public void testModifcarIdiomas() throws GestionHrException {
		idiomas.altaIdioma("prueba3", new BigDecimal(98), "prueba", "prueba2");
		assertNotNull(idiomas);
	}

	public void getSolicitudes() throws GestionHrException {
		List<IdiomasCandidato> idioma = idiomas.getIdiomas();
		System.out.println(idioma.toString());
		assertNotNull(idioma);
	}

	@Test
	public void getIdiomaById() throws GestionHrException {

		List<IdiomasCandidato> hola = idiomas.getIdiomasById(new BigDecimal(99));
		System.out.println(hola.size());
	}
}

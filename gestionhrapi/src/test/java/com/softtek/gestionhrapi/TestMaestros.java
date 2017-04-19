package com.softtek.gestionhrapi;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.jee.arq.spring.core.util.excepciones.PropiedadNoEncontradaExcepcion;
import com.bbva.jee.arq.spring.core.util.excepciones.PropiedadNoParseableExcepcion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/applicationContext*.xml" })
public class TestMaestros {

	@Autowired
	Maestros maestros;

	@Test
	public void testGetRoles() throws PropiedadNoEncontradaExcepcion,
			PropiedadNoParseableExcepcion {

		List<String> roles = maestros.getRoles();
		for (String rol : roles) {
			System.out.println("Rol: " + rol);
		}
	}
}

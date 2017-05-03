package com.softtek.gestionhrapi;

import java.math.BigDecimal;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.softtek.gestionhrapi.dominio.Tecnologias;
import com.softtek.gestionhrapi.dominio.exception.GestionHrException;
import com.softtek.gestionhrapi.dominio.interfaces.Tecnologias_Dao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml")
public class testModificarTecnologias {

	@Autowired
	Tecnologias_Dao pruebaUpdate;

	Tecnologias tecnoC = new Tecnologias();
	String nombre = "AAAA";
	String descripcion = "XXXX";
	BigDecimal id = new BigDecimal(38);

	/* Se comprueba que el nombre ha sido modificado correctamente */

	@Test
	public void testUpdate() throws GestionHrException {

		tecnoC = pruebaUpdate.readTecnologia(id);
		tecnoC.setNombre(nombre);
		pruebaUpdate.updateTecnologia(tecnoC);
		Assert.assertEquals(tecnoC.getNombre(), nombre);
	}

	/* Se comprueba que la descripcion ha sido modificado correctamente */
	@Test
	public void testUpdate1() throws GestionHrException {
		tecnoC = pruebaUpdate.readTecnologia(id);
		tecnoC.setDescripcion(descripcion);
		pruebaUpdate.updateTecnologia(tecnoC);
		Assert.assertEquals(tecnoC.getDescripcion(), descripcion);
	}

}

package com.softtek.gestionhrapi;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.softtek.gestionhrapi.dominio.Tecnologias;
import com.softtek.gestionhrapi.dominio.interfaces.Tecnologias_Dao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml")
public class testBajaTecnologias {

	@Autowired
	Tecnologias_Dao pruebaBaja;

	/* * Metodo que comprueba que se elimina una tecnologia */
	@Test
	public void borrarTecnologia() {

		long antes = Tecnologias.countTecnologiases();
		System.out.println("antes: " + antes);

		pruebaBaja.deleteTecnologia(new BigDecimal(110));

		long despues = Tecnologias.countTecnologiases();
		System.out.println("despues: " + despues);

		Assert.assertEquals(antes - 1, despues);

	}

}

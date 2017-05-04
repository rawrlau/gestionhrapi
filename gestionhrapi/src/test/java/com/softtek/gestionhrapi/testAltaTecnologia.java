package com.softtek.gestionhrapi;

import org.junit.Assert;
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
public class testAltaTecnologia {

	@Autowired
	Tecnologias_Dao pruebaAlta;

	/* * Metodo que Comprobacion alta de tecnologia */

	@Test
	public void altaTest() throws GestionHrException {

		long antes = Tecnologias.countTecnologiases();
		System.out.println("----- " + antes);

		Tecnologias tecnologiaAlta = tecnologiaInicial();
		if (tecnologiaAlta != null) {
			pruebaAlta.altaTecnologia(tecnologiaAlta);
		}
		long despues = Tecnologias.countTecnologiases();
		System.out.println("----- " + despues);
		Assert.assertEquals(antes + 1, despues);

	}

	/* * Inicializa una tecnologia */

	private Tecnologias tecnologiaInicial() {

		Tecnologias tecnoA = new Tecnologias();
		tecnoA.setNombre("c++");

		tecnoA.setDescripcion("leguaje prog");
		return tecnoA;
	}

}

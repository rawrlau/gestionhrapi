package com.softtek.gestionhrapi;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.gestionhrapi.dominio.Tecnologias;
import com.softtek.gestionhrapi.dominio.TecnologiasDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/applicationContext*.xml" })
@Transactional
public class TestTecnologias {
	
	@Autowired
	TecnologiasDAO tecnologias;

	@Test
	public void testCountEntidad() {
		long contador = Tecnologias.countTecnologiases();
		System.out.println("Número de tecnologias: " + contador);
		Assert.assertNotNull(contador);
	}

	@Test
	public void testAltaTecnologia() {
		
		long antes = Tecnologias.countTecnologiases();		
		
		int result = tecnologias.altaTecnologia("CSS", "Hola");
		
		System.out.println("Insertado: " + result);
		long despues = Tecnologias.countTecnologiases();
		System.out.println(antes + " " + despues);
		Assert.assertEquals(antes+1, despues);
		
		List<Tecnologias> lista =  Tecnologias.findAllTecnologiases();
		
		for (Tecnologias tecnologias : lista) {
			System.out.println(tecnologias.toString());
		}
	}
	
	
}
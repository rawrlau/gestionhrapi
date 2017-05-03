package com.softtek.gestionhrapi;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.softtek.gestionhrapi.dominio.IdiomasCandidato;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml")
public class testIdiomaCantidad {
	
	@Test
	
	public void numeroIdiomas(){
		long cantIdioma = IdiomasCandidato.countIdiomasCandidatoes();
		System.out.println("Idiomas: "+cantIdioma);
		assertNotNull(cantIdioma);
		
	}
}

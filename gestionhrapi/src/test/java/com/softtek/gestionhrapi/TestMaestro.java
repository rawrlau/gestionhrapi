package com.softtek.gestionhrapi;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.jee.arq.spring.core.util.excepciones.PropiedadNoEncontradaExcepcion;
import com.bbva.jee.arq.spring.core.util.excepciones.PropiedadNoParseableExcepcion;

/* Test de Maestros */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/spring/applicationContext*.xml"})
public class TestMaestro {

	@Autowired
	/*
	@Qualifier("maestros1")
	* Encontramos el bean y podemos renombrarlo como queramos, en este caso "maestros".
	*/
	Maestros maestros;
	
	@Test
	public void testGetRoles() throws PropiedadNoEncontradaExcepcion, PropiedadNoParseableExcepcion {
		
		//Recogemos un listado con los roles del properties.
		List<String> roles = maestros.getRoles();
		for(String rol:roles){
			System.out.println("Rol : " + rol );
		}
	}
	
}

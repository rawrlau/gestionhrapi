package com.softtek.gestionhrapi;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.softtek.gestionhrapi.dominio.interfaces.Contactos_Dao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml")
public class testConsultarContacto {

	@Autowired
	Contactos_Dao contactos;

	@Test
	public void ConsultaTecno() {

		contactos.consultarContactos(new BigDecimal(74));

	}
}
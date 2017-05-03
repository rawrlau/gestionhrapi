package com.softtek.gestionhrapi;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.softtek.gestionhrapi.dominio.interfaces.Tecnologias_Dao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml")
public class testConsultaTecnologias {

	@Autowired
	Tecnologias_Dao pruebaTecno;

	@Test
	public void ConsultaTecno() {
		pruebaTecno.consultarTecnologia(new BigDecimal(1));
		assertNotNull(pruebaTecno);
	}
}
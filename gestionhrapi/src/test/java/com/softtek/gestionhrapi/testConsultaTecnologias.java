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
public class testConsultaTecnologias {

	@Autowired
	Tecnologias_Dao pruebaRead;

	@Test
	public void testConsultaTecnologia() {
		try {
			Tecnologias tec = pruebaRead.readTecnologia(new BigDecimal(110));
			System.out.println();
			System.out.println("id: " + tec.getIdTecnologia());
			System.out.println("nombre: " + tec.getNombre());
			System.out.println("Descripcion: " + tec.getDescripcion());
			Assert.assertNotNull(tec);
		} catch (Exception e) {
			System.out.println("no lo encuentra");
		}

	}

}

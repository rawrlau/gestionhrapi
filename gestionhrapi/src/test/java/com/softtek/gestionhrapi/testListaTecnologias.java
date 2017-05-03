package com.softtek.gestionhrapi;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.softtek.gestionhrapi.dominio.Tecnologias;
import com.softtek.gestionhrapi.dominio.interfaces.Tecnologias_Dao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml")
public class testListaTecnologias {

	@Autowired
	Tecnologias_Dao pruebaLista;

	@Test
	public void ConsultarTecnologias() {
		List<Tecnologias> lista = pruebaLista.listaTecnologias();

		for (Tecnologias tecnologias : lista) {
			System.out.println("NOMBRE: " + tecnologias.getNombre() + " DESCRIPCION: " + tecnologias.getDescripcion());
		}
		Assert.assertNotNull(lista.size());

	}

}
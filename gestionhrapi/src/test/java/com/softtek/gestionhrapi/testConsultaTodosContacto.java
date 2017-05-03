package com.softtek.gestionhrapi;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.softtek.gestionhrapi.dominio.Contactos;
import com.softtek.gestionhrapi.dominio.interfaces.Contactos_Dao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml")
public class testConsultaTodosContacto {

	@Autowired
	Contactos_Dao contactos;

	@Test
	public void ConsultaTecno() {
		List<Contactos> lista = contactos.consultarTodosContactos();
		System.out.println(lista.size());
		Assert.assertNotNull(lista.size());
	}
}
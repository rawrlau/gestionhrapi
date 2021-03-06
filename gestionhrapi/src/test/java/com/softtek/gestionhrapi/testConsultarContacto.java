package com.softtek.gestionhrapi;

import java.math.BigDecimal;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.softtek.gestionhrapi.dominio.Contactos;
import com.softtek.gestionhrapi.dominio.exception.GestionHrException;
import com.softtek.gestionhrapi.dominio.interfaces.Contactos_Dao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml")
public class testConsultarContacto {

	private final I18nLog LOG = I18nLogFactory.getLogI18n(Contactos.class);

	@Autowired
	Contactos_Dao contactos;

	@Before
	public void setUp() {
		contactos.altaContactos(new BigDecimal(98), "contatcto98face", "Facebook");
	}

	@Test
	public void ConsutalContactoOK() throws GestionHrException {
		List<Contactos> contacto = contactos.consultarContactos(new BigDecimal(98));
		Assert.assertEquals(1, contacto.size());

	}

	@Test(expected = GestionHrException.class)
	public void ConsutalContactoNull() throws GestionHrException {
		contactos.consultarContactos(null);

	}

	@Test(expected = GestionHrException.class)
	public void ConsutalContactoInexistente() throws GestionHrException {
		List<Contactos> contacto = contactos.consultarContactos(new BigDecimal(-1));
	}

	@After
	public void destroy() {
		contactos.bajaContactos(new BigDecimal(98), "contatcto98face", "Facebook");
	}
}
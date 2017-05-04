package com.softtek.gestionhrapi;

import java.math.BigDecimal;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.softtek.gestionhrapi.dominio.Contactos;
import com.softtek.gestionhrapi.dominio.interfaces.Contactos_Dao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml")
public class testBajaContacto {

	private final I18nLog LOG = I18nLogFactory.getLogI18n(Contactos.class);

	@Autowired
	Contactos_Dao contacto;

	@Test
	public void bajaContacto() {
		long inicio = Contactos.countContactoses();
		LOG.info("\n Hay " + inicio + " contactos");
		contacto.bajaContactos(new BigDecimal(93), "hotmail", "c3po@hotmail.es");
		long fin = Contactos.countContactoses();
		LOG.info("\n Hay " + fin + " contactos");
		Assert.assertEquals(fin, inicio - 1);
	}
}
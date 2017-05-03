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
public class testAltaContacto {

	private final I18nLog LOG = I18nLogFactory.getLogI18n(Contactos.class);

	@Autowired
	Contactos_Dao contacto;

	@Test
	public void altaContacto() {
		long inicio = Contactos.countContactoses();
		LOG.info("\n Cantidad de contactos: " + inicio);
		contacto.altaContactos(new BigDecimal(74), "Facebook", "hola@hotmail.es");
		long fin = Contactos.countContactoses();
		LOG.info("\n Cantidad de contactos: " + fin);
		Assert.assertEquals(fin, inicio + 1);
	}
}

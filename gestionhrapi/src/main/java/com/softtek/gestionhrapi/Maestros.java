package com.softtek.gestionhrapi;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.contexto.ArqSpringContext;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.util.excepciones.PropiedadNoEncontradaExcepcion;
import com.bbva.jee.arq.spring.core.util.excepciones.PropiedadNoParseableExcepcion;

@Component
public class Maestros {
	
	private I18nLog LOG = I18nLogFactory.getLogI18n(Maestros.class);
	
	public List<String> getRoles() throws PropiedadNoEncontradaExcepcion, PropiedadNoParseableExcepcion{
		
		LOG.info("Se consultan los roles");
		List<String> roles = ArqSpringContext.getPropiedadList("maestrshr.roles");
		LOG.debug("se han cargado los roles "+roles.toString());
		
		return roles;
	}
}

package com.softtek.gestionhrapi;

import java.util.List;

import org.springframework.stereotype.Component;
import com.bbva.jee.arq.spring.core.contexto.ArqSpringContext;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.util.excepciones.PropiedadNoEncontradaExcepcion;
import com.bbva.jee.arq.spring.core.util.excepciones.PropiedadNoParseableExcepcion;

/* 
 * Clase para leer una properties.
 */

@Component
public class Maestros {
	
	//Crear un log de nuestra clase Maestros para mostrar los errores al nivel que queramos
	//y almacenarlos, en nuestro caso en gehr ==> logs.
	private I18nLog LOG = I18nLogFactory.getLogI18n(Maestros.class);
	
	//Metodo para acceder los roles de nuestra properties.
	public List<String> getRoles() throws PropiedadNoEncontradaExcepcion, PropiedadNoParseableExcepcion {
		
		LOG.info("Se consultan los roles");
		List<String>  roles = ArqSpringContext.getPropiedadList("maestroshr.roles");
		//Debug a nivel local.
		LOG.debug("Se han cargado los roles : " + roles.toString());
		return roles;
		
	}
	
}

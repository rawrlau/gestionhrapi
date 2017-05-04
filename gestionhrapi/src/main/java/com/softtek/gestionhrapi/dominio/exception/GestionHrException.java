package com.softtek.gestionhrapi.dominio.exception;

import org.jfree.util.Log;

import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.softtek.gestionhrapi.dominio.Tecnologias;

public class GestionHrException extends Exception {
	
	private I18nLog LOG = I18nLogFactory.getLogI18n(Tecnologias.class);
	
	public GestionHrException() {
		super();
		printStackTrace();
	}
	
	public GestionHrException(String message) {
		super(message);
		Log.error(message);
		printStackTrace();
	}

}

package com.softtek.gestionhrapi.exception;

import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.softtek.gestionhrapi.dominio.Solicitudes;

public class GestionhrException extends Exception{
	
	private I18nLog LOG = I18nLogFactory.getLogI18n(Solicitudes.class);
	
	public GestionhrException(){
		super();
	}
	
	public GestionhrException(String mensaje){
		super(mensaje);
		LOG.error("Exception");
	}

}

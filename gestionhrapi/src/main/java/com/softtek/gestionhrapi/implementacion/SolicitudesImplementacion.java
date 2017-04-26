package com.softtek.gestionhrapi.implementacion;

import java.math.BigDecimal;
import java.util.Date;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.softtek.gestionhrapi.dominio.Solicitudes;
import com.softtek.gestionhrapi.exception.GestionhrException;
import com.softtek.gestionhrapi.interfaz.SolicitudesInterfaz;

//@ContextConfiguration(locations = { "classpath:/META-INF/spring/applicationContext*.xml" } )
//@Component si simplemente queremos especificar que algo es un bean sin decir de qué tipo es podemos usar esta anotación.
@Component
public class SolicitudesImplementacion implements SolicitudesInterfaz {
	
	private I18nLog LOG = I18nLogFactory.getLogI18n(Solicitudes.class);
	
	@Override
	public void altaSolicitudCompleta(Solicitudes solicitud) throws GestionhrException {
		
			LOG.debug("Alta de solicitud, se comprueba el tipo");
			if(comprobarTipo(solicitud) == true){
				try{
				LOG.debug("Antes del persist");
				solicitud.persist();
				LOG.debug("Despues del persist");
				}catch(Exception e){
					LOG.error(e.getMessage());
					e.printStackTrace();
				}
				/*
				Solicitudes result = null;
				TypedQuery<Solicitudes> queryResult = (TypedQuery<Solicitudes>) Solicitudes.findSolicitudes(solicitud.getIdSolicitud());
				result = queryResult.getSingleResult();
				return result;
				*/
			}
	}
	
	@Override
	public void modificarSolicitud(Solicitudes solicitud) throws GestionhrException{
		
				LOG.debug("Modificacion de solicitud, se comprueba el tipo");
				if(comprobarTipo(solicitud) == true){
					try{
					LOG.debug("Antes del merge.");
					solicitud.merge();
					LOG.debug("Despues del merge");
					}catch(Exception e){
						LOG.error(e.getMessage());
						e.printStackTrace();
					}
				}
	}

	public boolean eliminarSolicitud(BigDecimal idSolicitud) throws GestionhrException{
		
			LOG.debug("Eliminar solicitud");
			Solicitudes solicitud = Solicitudes.findSolicitudes(idSolicitud);
			try{
			/*
			Solicitudes solicitud = null;
			TypedQuery<Solicitudes> queryResult = (TypedQuery<Solicitudes>) Solicitudes.findSolicitudes(idSolicitud);
			solicitud = queryResult.getSingleResult();
			*/
			LOG.debug("Antes del remove.");
			solicitud.remove();
			LOG.debug("Despues del remove.");
			LOG.debug("Solicitud eliminada");
			}catch(Exception e){
				LOG.error(e.getMessage());
				e.printStackTrace();
			}
			
			if(null == Solicitudes.findSolicitudes(solicitud.getIdSolicitud())){
				return true;
			}else{
				return false;
			}
	}
	
	@Override
	public Solicitudes getSolicitud(BigDecimal idSolicitud) throws GestionhrException {
		
		LOG.info("Obteniendo solicitudes");
		Solicitudes solicitud = Solicitudes.findSolicitudes(idSolicitud);
		if(solicitud == null){
			throw new GestionhrException("No se encuentra la solicitud con la Id : " + idSolicitud);
		}
		return solicitud;
		/*
		List<Solicitudes> listado = Solicitudes.findAllSolicitudeses();
		return listado;
		*/
	}

	@Override
	public long countSolicitudes() {
		LOG.info("Obteniendo el numero de solicitudes");
		return Solicitudes.countSolicitudeses();
	}
	 
	public boolean comprobarTipo(Solicitudes solicitud){
		
		boolean comprobar = false;
		if(solicitud.getNombre() instanceof String &&
		solicitud.getDescripcion() instanceof String &&
		solicitud.getFechaRecibida() instanceof Date &&
		solicitud.getCliente() instanceof String &&
		solicitud.getBrm() instanceof String &&
		solicitud.getAdm() instanceof String &&
		solicitud.getPerfil() instanceof String &&
		solicitud.getReqObligatorios() instanceof String &&
		solicitud.getReqDeseables() instanceof String &&
		solicitud.getIngles() instanceof String &&
		solicitud.getViajar() instanceof Character &&
		solicitud.getGuardias() instanceof Character &&
		solicitud.getConsultorasContactadas() instanceof String &&
		solicitud.getEstado() instanceof String){
			comprobar = true;
		}
		return comprobar;
	}
}

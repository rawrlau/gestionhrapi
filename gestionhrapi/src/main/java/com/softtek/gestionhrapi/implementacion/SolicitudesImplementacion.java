package com.softtek.gestionhrapi.implementacion;

import java.math.BigDecimal;
import java.util.List;

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

	private final I18nLog LOG = I18nLogFactory.getLogI18n(Solicitudes.class);

	@Override
	public void altaSolicitudCompleta(Solicitudes solicitud) {

		LOG.debug("Alta de solicitud, se comprueba el tipo");
		try {
			LOG.debug("Antes del persist");
			solicitud.persist();
			LOG.debug("Despues del persist");
		} catch (Exception e) {
			LOG.error(e, "Error al dar de alta");
		}
	}

	@Override
	public void modificarSolicitud(Solicitudes solicitud) {

		LOG.debug("Modificacion de solicitud, se comprueba el tipo");
		try {
			LOG.debug("Antes del merge.");
			solicitud.merge();
			LOG.debug("Despues del merge");
		} catch (Exception e) {
			LOG.error(e, "Error al dar de baja");
		}
	}

	@Override
	public boolean eliminarSolicitud(BigDecimal idSolicitud) {

		LOG.debug("Eliminar solicitud");
		Solicitudes solicitud = Solicitudes.findSolicitudes(idSolicitud);
		try {
			if (solicitud != null) {
				LOG.debug("Antes del remove.");
				solicitud.remove();
				LOG.debug("Despues del remove.");
				LOG.debug("Solicitud eliminada");
			} else {
				LOG.debug("No se ha podido dar de baja la solicitud");
			}
		} catch (Exception e) {
			LOG.error(e, "Error al eliminar");
		}

		if (null == Solicitudes.findSolicitudes(solicitud.getIdSolicitud())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Solicitudes getSolicitud(BigDecimal idSolicitud) throws GestionhrException {

		LOG.info("Obteniendo solicitudes");
		Solicitudes solicitud = Solicitudes.findSolicitudes(idSolicitud);
		if (solicitud == null) {
			throw new GestionhrException("No se encuentra la solicitud con la Id : " + idSolicitud);
		}
		return solicitud;
	}

	@Override
	public long countSolicitudes() {
		LOG.info("Obteniendo el numero de solicitudes");
		return Solicitudes.countSolicitudeses();
	}

	@Override
	public List<Solicitudes> getListaSolicitudes() throws GestionhrException {
		List<Solicitudes> solicitud = Solicitudes.findAllSolicitudeses();
		return solicitud;
	}
}

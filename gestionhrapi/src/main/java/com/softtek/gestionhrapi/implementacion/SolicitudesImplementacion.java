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

		LOG.debug("Alta de solicitud (Implementación)");
		try {
			LOG.debug("Antes del persist (Implementación)");
			solicitud.persist();
			LOG.debug("Despues del persist (Implementación)");
		} catch (Exception e) {
			LOG.error(e, "Error al dar de alta (Implementación)");
		}
	}

	@Override
	public void modificarSolicitud(Solicitudes solicitud) {

		LOG.debug("Modificacion de solicitud (Implementación)");
		try {
			LOG.debug("Antes del merge (Implementación)");
			solicitud.merge();
			LOG.debug("Despues del merge (Implementación)");
		} catch (Exception e) {
			LOG.error("Error al modificar (Implementación)");
		}
	}

	@Override
	public boolean eliminarSolicitud(BigDecimal idSolicitud) {

		LOG.debug("Eliminar solicitud (Implementación)");
		Solicitudes solicitud = Solicitudes.findSolicitudes(idSolicitud);
		try {
			LOG.debug("Antes del remove (Implementación)");
			solicitud.remove();
			LOG.debug("Despues del remove (Implementación)");
		} catch (Exception e) {
			LOG.error(e, "Error al eliminar (Implementación)");
		}

		if (null == Solicitudes.findSolicitudes(solicitud.getIdSolicitud())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Solicitudes getSolicitud(BigDecimal idSolicitud) throws GestionhrException {

		LOG.info("Obteniendo solicitud por Id (Implementación)");
		Solicitudes solicitud = Solicitudes.findSolicitudes(idSolicitud);
		if (solicitud == null) {
			LOG.info("No se encuentra la solicitud con la Id (Implementación): " + idSolicitud);
		}
		return solicitud;
	}

	@Override
	public long countSolicitudes() {
		// LOG.info("Obteniendo el numero de solicitudes (Implementación)");
		return Solicitudes.countSolicitudeses();
	}

	@Override
	public List<Solicitudes> getListaSolicitudes() throws GestionhrException {
		List<Solicitudes> solicitud = Solicitudes.findAllSolicitudeses();
		return solicitud;
	}
}

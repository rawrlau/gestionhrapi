package com.softtek.gestionhrapi.dominio.interfaces;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.softtek.gestionhrapi.dominio.Tecnologias;

@Component
public class Tecnologias_Daoimpl implements Tecnologias_Dao {
	private final I18nLog LOG = I18nLogFactory.getLogI18n(Tecnologias.class);

	@Override
	public void altaTecnologia(String nombre, String descripcion) {
		Tecnologias tecno = new Tecnologias();
		tecno.setNombre(nombre);
		tecno.setDescripcion(descripcion);

		try {
			LOG.info("\n insertando en la base de datos");
			tecno.persist();
			BigDecimal idtect = tecno.getIdTecnologia();
			LOG.info("\n insertado en la base de datos con id: " + idtect);
		} catch (Exception e) {
			LOG.error("no se realizo el alta " + e.getMessage());
			e.getStackTrace();
		}
	}

	@Override
	public void borrarTecnologia(BigDecimal idTecnologias) {
		Tecnologias tecno = new Tecnologias();
		tecno.findTecnologias(idTecnologias);
		tecno.setIdTecnologia(idTecnologias);
		try {
			LOG.info("borrando..");
			tecno.remove();
			LOG.info("borrado correctamente");
		} catch (Exception e) {
			LOG.error("no se realizo la baja " + e.getMessage());
			e.getStackTrace();
		}
	}

	@Override
	public void modificarTecnologia(String nombre, String descripcion, BigDecimal idTecnologias) {
		Tecnologias tecno = new Tecnologias();
		tecno.findTecnologias(idTecnologias);
		tecno.setIdTecnologia(idTecnologias);
		LOG.info("Cambiando datos de: " + tecno.getIdTecnologia());
		try {
			tecno.setNombre(nombre);
			tecno.setDescripcion(descripcion);
			tecno.merge();
			LOG.info("nombre y descripcion cambiados.");
		} catch (Exception e) {
			LOG.error("no se realizo la modificacion con exito " + e.getMessage());
			e.getStackTrace();
		}
	}

	@Override
	public Tecnologias consultarTecnologia(BigDecimal idTecnologias) {

		Tecnologias tecno = Tecnologias.findTecnologias(idTecnologias);

		try {
			LOG.info("\n NOMBRE: " + tecno.getNombre() + "\n DESCRIPCION: " + tecno.getDescripcion());
		} catch (Exception e) {
			LOG.error("\n no existe la tecnologia " + e.getMessage());
			e.getStackTrace();
		}

		return tecno;
	}

}

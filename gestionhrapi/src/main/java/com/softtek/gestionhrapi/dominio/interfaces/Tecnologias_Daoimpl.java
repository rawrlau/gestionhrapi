package com.softtek.gestionhrapi.dominio.interfaces;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.softtek.gestionhrapi.dominio.Tecnologias;
import com.softtek.gestionhrapi.dominio.exception.GestionHrException;

@Component
public class Tecnologias_Daoimpl implements Tecnologias_Dao {
	private final I18nLog LOG = I18nLogFactory.getLogI18n(Tecnologias.class);

	@Override
	public void altaTecnologia(Tecnologias tecno) throws GestionHrException {

		LOG.debug("Alta de tecnologia");
		try {
			tecno.persist();
			LOG.debug("\n Modificación de candidato realizada con éxito.");
		} catch (Exception e) {
			LOG.error("\n Error al insertar tecnologia " + e.getMessage());
		}

	}

	@Override
	public void deleteTecnologia(BigDecimal idTecnologias) {

		Tecnologias tecno = Tecnologias.findTecnologias(idTecnologias);

		try {
			if (tecno != null) {
				tecno.remove();
				LOG.info("\nborrado Correctamente ");
			}
		} catch (Exception e) {
			LOG.error("\nno se ha borrado correctamene " + e.getMessage());
		}

	}

	@Override
	public Tecnologias readTecnologia(BigDecimal idTecnologia) throws GestionHrException {

		Tecnologias tecno = Tecnologias.findTecnologias(idTecnologia);
		LOG.info("\n Tecnologia encontrada: ");
		if (tecno == null) {
			throw new GestionHrException("No se encuentra la tecnologia con la Id : " + idTecnologia);
		}
		return tecno;
	}

	@Override
	public void updateTecnologia(Tecnologias tecno) throws GestionHrException {

		try {
			tecno.merge();
			LOG.info("Modificación de tecnologia realizada con éxito.");
		} catch (Exception e) {
			LOG.error("\n NO se ha realizado la Modificacion " + e.getMessage());
		}

	}

	@Override
	public List<Tecnologias> listaTecnologias() {
		return Tecnologias.findAllTecnologiases();
	}

}

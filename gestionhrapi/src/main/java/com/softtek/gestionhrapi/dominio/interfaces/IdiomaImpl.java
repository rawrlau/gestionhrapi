package com.softtek.gestionhrapi.dominio.interfaces;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.softtek.gestionhrapi.dominio.Candidatos;
import com.softtek.gestionhrapi.dominio.IdiomasCandidato;
import com.softtek.gestionhrapi.dominio.IdiomasCandidatoPK;
import com.softtek.gestionhrapi.dominio.exception.GestionHrException;

@Component
public class IdiomaImpl implements IdiomaCandidato {
	private final I18nLog Log = I18nLogFactory.getLogI18n(IdiomasCandidato.class);

	@Override
	public void altaIdioma(String idioma, BigDecimal idCandidato, String descripcion, String nivel)
			throws GestionHrException {
		// TODO Auto-generated method stub
		IdiomasCandidato idiomas = new IdiomasCandidato();
		IdiomasCandidatoPK idiomaPK = new IdiomasCandidatoPK(idioma, idCandidato, nivel);
		Candidatos candidato = Candidatos.findCandidatos(idCandidato);
		idiomas.setId(idiomaPK);
		idiomas.setDescripcion(descripcion);
		try {
			Log.debug("Idioma dado de alta");
			Log.info("Candidato: " + candidato.getNombre() + " " + candidato.getApellidos() + " " + nivel + " "
					+ descripcion);
			idiomas.persist();
		} catch (Exception e) {
			Log.error("Error al insertar idioma", e.getMessage());
			e.getStackTrace();
		}
	}

	@Override
	public boolean bajaIdioma(String idioma, BigDecimal idCandidato, String descripcion, String nivel)
			throws GestionHrException {
		// TODO Auto-generated method stub
		Log.debug("Metodo para dar de baja un idioma");
		Candidatos candidato = Candidatos.findCandidatos(idCandidato);
		candidato.getIdCandidato();
		IdiomasCandidatoPK idiomasPK = new IdiomasCandidatoPK(idioma, idCandidato, nivel);
		IdiomasCandidato idiomas = new IdiomasCandidato();
		idiomas.setId(idiomasPK);
		try {
			Log.debug("Darse de baja");
			idiomas.remove();
			Log.debug("Despues del remove");
			Log.info("Idioma eliminado");
		} catch (Exception e) {
			Log.error("Error al borrar", e.getMessage());
			e.printStackTrace();
		}
		if (null == IdiomasCandidato.findIdiomasCandidato(idiomas.getId())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void modificarIdioma(String idioma, BigDecimal idCandidato, String descripcion, String nivel)
			throws GestionHrException {
		// TODO Auto-generated method stub
		Log.debug("Metodo para modificar un idioma");
		IdiomasCandidato idiomas = new IdiomasCandidato();
		Log.debug("Modificar idioma");
		try {
			Log.debug("Antes del merge");
			idiomas.merge();
			Log.debug("Despues del merge");
		} catch (Exception e) {
			Log.error("Error al modificar", e.getMessage());
			e.getStackTrace();
		}
	}

	@Override
	public List<IdiomasCandidato> getIdiomas() throws GestionHrException {
		List<IdiomasCandidato> idioma = IdiomasCandidato.findAllIdiomasCandidatoes();
		return idioma;
	}

	@Override
	public List<IdiomasCandidato> getIdiomasById(BigDecimal idCandidato) throws GestionHrException {
		List<IdiomasCandidato> idioma = IdiomasCandidato.findIdiomasCandidatoPorId(idCandidato);
		return idioma;
	}

}

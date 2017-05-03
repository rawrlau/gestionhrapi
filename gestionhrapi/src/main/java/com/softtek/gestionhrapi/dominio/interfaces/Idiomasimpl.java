package com.softtek.gestionhrapi.dominio.interfaces;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.softtek.gestionhrapi.dominio.Candidatos;
import com.softtek.gestionhrapi.dominio.IdiomasCandidato;
import com.softtek.gestionhrapi.dominio.IdiomasCandidatoPK;

@Component
public class Idiomasimpl implements Idiomas_Dao {
	private final I18nLog LOG = I18nLogFactory.getLogI18n(IdiomasCandidato.class);

	@Override
	public void altaIdioma(String idioma, BigDecimal idCandidato, String nivel, String descripcion) {

		IdiomasCandidato idiomas = new IdiomasCandidato();
		IdiomasCandidatoPK idiomaPK = new IdiomasCandidatoPK(idioma, idCandidato, nivel);
		Candidatos candidato = Candidatos.findCandidatos(idCandidato);
		try {
			idiomas.setId(idiomaPK);
			idiomas.setDescripcion(descripcion);
			LOG.info("\n Candidato: " + candidato.getNombre() + " " + candidato.getApellidos() + "\n " + idioma + " : "
					+ nivel + "\n descripcion del idioma: " + descripcion);
			idiomas.persist();
		} catch (Exception e) {
			LOG.error("no se realizo el alta " + e.getMessage());
			e.getStackTrace();
		}
	}

}

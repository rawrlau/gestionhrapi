package com.softtek.gestionhrapi.dominio;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import org.jfree.util.Log;
import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

@Component
public class CandidatosDAOImpl implements CandidatosDAO {

	private I18nLog LOG = I18nLogFactory.getLogI18n(Candidatos.class);

	@Override
	public int altaCandidato(Candidatos candidato) {
		try {
			System.out.println(candidato.toString());

			candidato.persist();
			LOG.info("Alta de candidato realizada con éxito.");

		} catch (Exception e) {
			LOG.error("No ha sido posible realizar el alta del candidato: "
					+ e.getMessage());
			e.printStackTrace();
			return 0; // Error
		}
		return 1; // OK
	}

	@Override
	public int bajaCandidato(BigDecimal idCandidato) {
		Candidatos candidato = new Candidatos();
		candidato.setIdCandidato(idCandidato);
		try {
			candidato.remove();
			LOG.info("Baja de candidato realizada con éxito.");
		} catch (Exception e) {
			LOG.error("No ha sido posible realizar la baja del candidato: "
					+ e.getMessage());
			e.printStackTrace();
			return 0; // Error
		}
		return 1; // OK
	}

	@Override
	public int modificacionCandidato(Candidatos candidato) {
		try {
			candidato.merge();

			LOG.info("Modificación de candidato realizada con éxito.");

		} catch (Exception e) {
			LOG.error("No ha sido posible realizar la modificación del candidato: "
					+ e.getMessage());
			e.printStackTrace();;
			return 0; // Error
		}
		return 1; // OK
	}

	@Override
	public Candidatos consultaCandidato(BigDecimal idCandidato) {

		Candidatos candidato = Candidatos.findCandidatos(idCandidato);

		try {
			if (candidato == null)
				LOG.warn("Candidato no existente");
			else {
				LOG.info("Candidato encontrado");
				return candidato; // OK
			}
		} catch (Exception e) {
			LOG.error("Error al consultar el candidato: " + e.getMessage());
			e.printStackTrace();
		}

		return null; // Error
	}
}

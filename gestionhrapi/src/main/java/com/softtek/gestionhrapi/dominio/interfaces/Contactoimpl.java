package com.softtek.gestionhrapi.dominio.interfaces;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.softtek.gestionhrapi.dominio.Candidatos;
import com.softtek.gestionhrapi.dominio.Contactos;
import com.softtek.gestionhrapi.dominio.ContactosPK;

@Component
public class Contactoimpl implements Contactos_Dao {
	private final I18nLog LOG = I18nLogFactory.getLogI18n(Contactos.class);

	@Override
	public void altaContactos(BigDecimal idCandidato, String tipoContacto, String valor) {

		Candidatos candidato = Candidatos.findCandidatos(idCandidato);
		ContactosPK contactoPK = new ContactosPK(tipoContacto, valor, idCandidato);
		Contactos contacto = new Contactos();
		contacto.setId(contactoPK);
		contacto.setIdCandidato(candidato);
		try {
			LOG.info("\n Candidato: " + candidato.getNombre() + " " + candidato.getApellidos() + "\n " + tipoContacto
					+ " : " + valor);
			contacto.persist();
			LOG.info("\n alta con exito");
		} catch (Exception e) {
			LOG.error("no se realizo el alta " + e.getMessage());
			e.getStackTrace();
		}
	}

	@Override
	public void bajaContactos(BigDecimal idCandidato, String tipoContacto, String valor) {

		Candidatos candidato = Candidatos.findCandidatos(idCandidato);
		ContactosPK contactoPK = new ContactosPK(tipoContacto, valor, idCandidato);
		Contactos contacto = new Contactos();
		contacto.setId(contactoPK);
		try {
			contacto.remove();
			LOG.info("\n Datos borrados: " + tipoContacto + " " + valor + "\n del contacto: " + candidato.getNombre()
					+ " " + candidato.getApellidos());
		} catch (Exception e) {
			LOG.error(e, "no se realizo la baja " + e.getMessage());
			e.getStackTrace();
		}

	}

	@Override
	public List<Contactos> consultarContactos(BigDecimal idCandidato) {
		try {
			Candidatos candidato = Candidatos.findCandidatos(idCandidato);
			LOG.info("\n Candidato: " + candidato.getNombre() + " " + candidato.getApellidos());
			return Contactos.findContactosByCandidato(idCandidato);
		} catch (Exception e) {
			LOG.error(e, "\n no existe el contacto " + e.getMessage());
			e.getStackTrace();
		}
		return null;
	}

	@Override
	public List<Contactos> consultarTodosContactos() {
		try {
			return Contactos.findAllContactoses();
		} catch (Exception e) {
			LOG.error(e, "\n no hay contactos  " + e.getMessage());
			e.getStackTrace();
		}
		return null;
	}

}

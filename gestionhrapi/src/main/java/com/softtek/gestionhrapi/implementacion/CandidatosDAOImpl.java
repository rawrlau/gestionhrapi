package com.softtek.gestionhrapi.implementacion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.softtek.exception.GestionHrException;
import com.softtek.gestionhrapi.dominio.Candidatos;

@Component
public class CandidatosDAOImpl implements CandidatosDAO {

	private I18nLog LOG = I18nLogFactory.getLogI18n(Candidatos.class);

	/**
	 * Crea un nuevo candidato en la base de datos
	 */
	@Override
	public void createCandidato(Candidatos candidato) throws GestionHrException {
		if (validateCandidato(candidato)) {
			candidato.persist();
			LOG.info("Alta realizada con éxito.");
		}
	}

	/**
	 * Devuelve un candidato cuya Id se le pasa por parámetro
	 */
	@Override
	public Candidatos readCandidato(BigDecimal idCandidato) throws GestionHrException {
		Candidatos candidato = null;
		if (validateIdCandidato(idCandidato)) {
			candidato = Candidatos.findCandidatos(idCandidato);
			LOG.info("Candidato encontrado: " + candidato.toString());
		}
		return candidato;
	}

	/**
	 * Devuelve una lista con todos los candidatos
	 */
	@Override
	public List<Candidatos> readAllCandidatos() throws GestionHrException {
		return Candidatos.findAllCandidatoses();
	}

	/**
	 * Devuelve una lista de un número limitado (max) de candidatos
	 */
	@Override
	public List<Candidatos> readAllCandidatos(int max) throws GestionHrException {
		List<Candidatos> lista = Candidatos.findAllCandidatoses();
		List<Candidatos> listaLimitada = new ArrayList<Candidatos>();
		for (int i = 0; i < max; i++)
			listaLimitada.add(lista.get(i));
		return listaLimitada;
	}

	/**
	 * Actualiza un candidato de la base de datos.
	 */
	@Override
	public void updateCandidato(Candidatos candidato) throws GestionHrException {
		if (validateCandidato(candidato)) {
			candidato.merge();
			LOG.info("Modificación de candidato realizada con éxito.");
		}
	}

	/**
	 * Borra un candidato de la base de datos.
	 */
	@Override
	public void deleteCandidato(BigDecimal idCandidato) throws GestionHrException {
		Candidatos candidato = readCandidato(idCandidato);
		candidato.remove();
		LOG.info("Baja de candidato realizada con éxito.");
	}

	/**
	 * Devuelve true si encuentra la idCandidato existe en la lista de
	 * Candidatos. Si no existe devuelve false.
	 * 
	 * @param idCandidato
	 * @return
	 * @throws GestionHrException
	 */
	private boolean validateIdCandidato(BigDecimal idCandidato) throws GestionHrException {
		List<Candidatos> lista = Candidatos.findAllCandidatoses();
		for (Candidatos candidato : lista)
			if (candidato.getIdCandidato().equals(idCandidato))
				return true;
		throw new GestionHrException("La ID CANDIDATO no existe en la base de datos.");
	}

	/**
	 * Comprueba que el candidato pasado por parámetro tiene sus atributos Not
	 * Null no vacíos. Si alguno de ellos fuera null lanza una excepción, si no,
	 * devuelve true
	 * 
	 * @param candidato
	 * @return
	 * @throws GestionHrException
	 */
	private boolean validateCandidato(Candidatos candidato) throws GestionHrException {

		String nuloVar = "";
		String nuloMensaje = "no puede ser null";

		if (candidato == null)
			nuloVar = "El CANDIDATO";
		else if (candidato.getNombre() == null)
			nuloVar = "NOMBRE";
		else if (candidato.getProvincia() == null)
			nuloVar = "PROVINCIA";
		else if (candidato.getPerfil() == null)
			nuloVar = "PERFIL";
		else if (candidato.getExpectContractual() == null)
			nuloVar = "EXPEC. CONTRACTUAL";
		else if (candidato.getExpectEconomica() == null)
			nuloVar = "EXPEC. ECONÓMICA";
		else if (candidato.getFeedbackSourcing() == null)
			nuloVar = "FEEDBACK SOURCING";
		else if (candidato.getTecnicoSeleccion() == null)
			nuloVar = "TÉCNICO SELECCIÓN";

		if (nuloVar.isEmpty())
			return true;
		else {
			throw new GestionHrException(nuloVar + " " + nuloMensaje);
		}

	}

}

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
			LOG.info("Alta realizada con Èxito.");
		}
	}

	/**
	 * Devuelve un candidato cuya Id se le pasa por par·metro
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
		List<Candidatos> lista = Candidatos.findAllCandidatoses();
		LOG.info("======== Lista de candidatos ========");
		for (Candidatos candidato : lista) {
			System.out.println(candidato.toString());
		}
		return lista;
	}

	/**
	 * Devuelve una lista de un n˙mero limitado (max) de candidatos
	 */
	@Override
	public List<Candidatos> readAllCandidatos(int max) throws GestionHrException {
		List<Candidatos> lista = Candidatos.findAllCandidatoses();
		List<Candidatos> listaLimitada = new ArrayList<Candidatos>();
		LOG.info("======== Lista de candidatos ========");
		for (int i = 0; i < max; i++) {
			listaLimitada.add(lista.get(i));
			System.out.println(listaLimitada.get(i).toString());
		}
		return listaLimitada;
	}

	/**
	 * Encuentra los candidatos en funciÛn del nombre
	 */
	@Override
	public List<Candidatos> findCandidatoByNombre(String nombre) throws GestionHrException {
		List<Candidatos> lista = null;
		try {
			LOG.info("======== Lista de candidatos ========");
			lista = Candidatos
					.entityManager()
					.createQuery(
							"SELECT o FROM Candidatos o WHERE LOWER(translate(NOMBRE, '·ÈÌÛ˙¡…Õ”⁄', 'aeiouAEIOU')) like LOWER(translate(:nombre, '·ÈÌÛ˙¡…Õ”⁄', 'aeiouAEIOU'))",
							Candidatos.class).setParameter("nombre", "%" + nombre + "%").getResultList();
			return lista;
		} catch (Exception e) {
			LOG.error("Error SQL.");
			return lista;
		}
	}

	/**
	 * Encuentra los candidatos en funciÛn de los apellidos
	 */
	@Override
	public List<Candidatos> findCandidatoByApellidos(String apellidos) {
		return Candidatos
				.entityManager()
				.createQuery(
						"SELECT o FROM Candidatos o WHERE LOWER(translate(APELLIDOS, '·ÈÌÛ˙¡…Õ”⁄', 'aeiouAEIOU')) like LOWER(translate(:apellidos, '·ÈÌÛ˙¡…Õ”⁄', 'aeiouAEIOU'))",
						Candidatos.class).setParameter("apellidos", "%" + apellidos + "%").getResultList();
	}

	/**
	 * Encuentra los candidatos en funciÛn del estado
	 */
	@Override
	public List<Candidatos> findCandidatoByEstado(String estado) {
		return Candidatos.entityManager()
				.createQuery("SELECT o FROM Candidatos o WHERE ESTADO like :estado", Candidatos.class)
				.setParameter("estado", estado).getResultList();
	}

	/**
	 * Encuentra los candidatos en funciÛn del perfil
	 */
	@Override
	public List<Candidatos> findCandidatoByPerfil(String perfil) {
		return Candidatos.entityManager()
				.createQuery("SELECT o FROM Candidatos o WHERE PERFIL like :perfil", Candidatos.class)
				.setParameter("perfil", perfil).getResultList();
	}

	/**
	 * Actualiza un candidato de la base de datos.
	 */
	@Override
	public void updateCandidato(Candidatos candidato) throws GestionHrException {
		if (validateCandidato(candidato)) {
			candidato.merge();
			LOG.info("ModificaciÛn de candidato realizada con Èxito.");
		}
	}

	/**
	 * Borra un candidato de la base de datos.
	 */
	@Override
	public void deleteCandidato(BigDecimal idCandidato) throws GestionHrException {
		Candidatos candidato = readCandidato(idCandidato);
		candidato.remove();
		LOG.info("Baja de candidato realizada con Èxito.");
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
	 * Comprueba que el candidato pasado por par·metro tiene sus atributos Not
	 * Null no vacÌos. Si alguno de ellos fuera null lanza una excepciÛn, si no,
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
			nuloVar = "EXPEC. ECON”MICA";
		else if (candidato.getFeedbackSourcing() == null)
			nuloVar = "FEEDBACK SOURCING";
		else if (candidato.getTecnicoSeleccion() == null)
			nuloVar = "T…CNICO SELECCI”N";

		if (nuloVar.isEmpty())
			return true;
		else {
			throw new GestionHrException(nuloVar + " " + nuloMensaje);
		}

	}

}

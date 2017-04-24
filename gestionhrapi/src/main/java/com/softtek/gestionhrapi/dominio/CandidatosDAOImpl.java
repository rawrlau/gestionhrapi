package com.softtek.gestionhrapi.dominio;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import org.jfree.util.Log;
import org.springframework.stereotype.Component;

@Component
public class CandidatosDAOImpl implements CandidatosDAO {

	@Override
	public int altaCandidato(Set<Solicitudes> solicitudes,
			Set<Tecnologias> tecnologiass1, Set<Contactos> contactoss,
			Set<IdiomasCandidato> idiomasCandidatoes, String nombre,
			String apellido, String provincia, String perfil, String posicion,
			String experiencia, String dispViajar, String dispResidencia,
			String dispIncorporacion, String expContractual,
			BigDecimal expEconomica, Date fecha_entrevista,
			String feedbackSourcing, String feedbackTecnico,
			String tecnicoSeleccion, String referenciado, String estado,
			String cvSofttek, String cvPersonal, Date fechaContacto,
			Date fechaActualizado) {
		try {
			Candidatos candidato = new Candidatos();
			candidato.setIdCandidato(new BigDecimal(2));
			candidato.setSolicitudeses(solicitudes);
			candidato.setTecnologiass1(tecnologiass1);
			candidato.setContactoss(contactoss);
			candidato.setIdiomasCandidatoes(idiomasCandidatoes);
			candidato.setNombre(nombre);
			candidato.setApellidos(apellido);
			candidato.setProvincia(provincia);
			candidato.setPerfil(perfil);
			candidato.setPosicion(posicion);
			candidato.setExperiencia(experiencia);
			candidato.setDispViajar(dispViajar);
			candidato.setDispResidencia(dispResidencia);
			candidato.setDispIncorporacion(dispIncorporacion);
			candidato.setExpectContractual(expContractual);
			candidato.setExpectEconomica(expEconomica);
			candidato.setFechaEntrevista(fecha_entrevista);
			candidato.setFeedbackSourcing(feedbackSourcing);
			candidato.setFeedbackTecnico(feedbackTecnico);
			candidato.setTecnicoSeleccion(tecnicoSeleccion);
			candidato.setReferenciado(referenciado);
			candidato.setEstado(estado);
			candidato.setCvSofttek(cvSofttek);
			candidato.setCvPersonal(cvPersonal);
			candidato.setFechaContacto(fechaContacto);
			candidato.setFechaActualizado(fechaActualizado);	

			System.out.println(candidato.toString());			

			//candidato.entityManager.getTransaction().begin();
			candidato.persist();
			//candidato.entityManager.getTransaction().commit();
			Log.info("Alta de candidato realizada con éxito.");

		} catch (Exception e) {
			Log.error("No ha sido posible realizar el alta del candidato.");
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
			Log.info("Baja de candidato realizada con éxito.");
		} catch (Exception e) {
			Log.error("No ha sido posible realizar la baja del candidato.");
			return 0; // Error
		}
		return 1; // OK
	}

	@Override
	public int modificacionCandidato(Set<Solicitudes> solicitudes,
			Set<Tecnologias> tecnologiass1, Set<Contactos> contactoss,
			Set<IdiomasCandidato> idiomasCandidatoes, String nombre,
			String apellido, String provincia, String perfil, String posicion,
			String experiencia, String dispViajar, String dispResidencia,
			String dispIncorporacion, String expContractual,
			BigDecimal expEconomica, Date fecha_entrevista,
			String feedbackSourcing, String feedbackTecnico,
			String tecnicoSeleccion, String referenciado, String estado,
			String cvSofttek, String cvPersonal, Date fechaContacto,
			Date fechaActualizado) {
		try {
			Candidatos candidato = new Candidatos();
			candidato.setIdCandidato(new BigDecimal(2));
			candidato.setSolicitudeses(solicitudes);
			candidato.setTecnologiass1(tecnologiass1);
			candidato.setContactoss(contactoss);
			candidato.setIdiomasCandidatoes(idiomasCandidatoes);
			candidato.setNombre(nombre);
			candidato.setApellidos(apellido);
			candidato.setProvincia(provincia);
			candidato.setPerfil(perfil);
			candidato.setPosicion(posicion);
			candidato.setExperiencia(experiencia);
			candidato.setDispViajar(dispViajar);
			candidato.setDispResidencia(dispResidencia);
			candidato.setDispIncorporacion(dispIncorporacion);
			candidato.setExpectContractual(expContractual);
			candidato.setExpectEconomica(expEconomica);
			candidato.setFechaEntrevista(fecha_entrevista);
			candidato.setFeedbackSourcing(feedbackSourcing);
			candidato.setFeedbackTecnico(feedbackTecnico);
			candidato.setTecnicoSeleccion(tecnicoSeleccion);
			candidato.setReferenciado(referenciado);
			candidato.setEstado(estado);
			candidato.setCvSofttek(cvSofttek);
			candidato.setCvPersonal(cvPersonal);
			candidato.setFechaContacto(fechaContacto);
			candidato.setFechaActualizado(fechaActualizado);

			//candidato.entityManager.getTransaction().begin();
			candidato.flush();
			//candidato.entityManager.getTransaction().commit();

			Log.info("Modificación de candidato realizada con éxito.");

		} catch (Exception e) {
			Log.error("No ha sido posible realizar la modificación del candidato.");
			return 0; // Error
		}
		return 1; // OK
	}

	@Override
	public int consultaCandidato(BigDecimal idCandidato) {
		try {
			if (Candidatos.findCandidatos(idCandidato) == null)
				Log.warn("Candidato no existente");
			else
				Log.info("Candidato encontrado");
			
		} catch (Exception e) {
			Log.error("Error al consultar el candidato");
			return 0; // Error
		}
		return 1; // OK		
	}
}

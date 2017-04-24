package com.softtek.gestionhrapi.dominio;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public interface CandidatosDAO {

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
			Date fechaActualizado);

	public int bajaCandidato(BigDecimal idCandidato);

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
			Date fechaActualizado);

	public int consultaCandidato(BigDecimal idCandidato);
}

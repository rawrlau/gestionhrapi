package com.softtek.gestionhrapi.dominio;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;


//RooJavaBean se encarga de generar los get y set de los atributos.
@RooJavaBean
// RooToString se encarga de generar un toString() con los atributos.
@RooToString
// RooEntity se encarga de inyectar las operaciones de consulta, update, insert
// y delete.
@RooEntity(versionField = "", table = "SOLICITUDES", schema = "FORMACION")
// RooDbManaged esta asociada con un aspecto que define los campos persistentes
// (las columnas) de la entidad.
@RooDbManaged(automaticallyDelete = true)
@XmlRootElement(name = "infoSolicitudes", namespace = "solicitud")
@XmlType(name = "infoSolicitudes", namespace = "solicitud")
public class Solicitudes {

	// Secuencia incremental del ID.
	@Id
	@SequenceGenerator(name = "SEQ_SOLICITUDES", sequenceName = "SEQ_SOLICITUDES", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SOLICITUDES")
	@Column(name = "ID_SOLICITUD")
	private BigDecimal idSolicitud;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "solicitudeses")
	private Set<Candidatos> candidatoss;

	@Column(name = "VIAJAR")
	private String viajar;

	@Column(name = "GUARDIAS")
	private String guardias;

	public Set<Candidatos> getCandidatoss() {
		return this.candidatoss;
	}

	public void setCandidatoss(Set<Candidatos> candidatoss) {
		this.candidatoss = candidatoss;
	}

	public BigDecimal getIdSolicitud() {
		return this.idSolicitud;
	}

	public void setIdSolicitud(BigDecimal id) {
		this.idSolicitud = id;
	}

	public String getViajar() {
		return viajar;
	}

	public void setViajar(String viajar) {
		this.viajar = viajar;
	}

	public String getGuardias() {
		return guardias;
	}

	public void setGuardias(String guardias) {
		this.guardias = guardias;
	}
}

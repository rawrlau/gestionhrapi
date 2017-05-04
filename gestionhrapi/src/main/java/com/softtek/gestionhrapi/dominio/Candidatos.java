package com.softtek.gestionhrapi.dominio;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(versionField = "", table = "CANDIDATOS", schema = "FORMACION")
@RooDbManaged(automaticallyDelete = true)
@XmlRootElement(name = "candidatos", namespace = "candidatos")
@XmlType(name = "candidatos", namespace = "candidatos")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Candidatos {

	@Id
	@SequenceGenerator(name = "SEQ_CANDIDATOS", sequenceName = "SEQ_CANDIDATOS", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CANDIDATOS")
	@Column(name = "ID_CANDIDATO")
	private BigDecimal idCandidato;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "SOLICITUDES_CANDIDATO", joinColumns = { @JoinColumn(name = "ID_CANDIDATO", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "ID_SOLICITUD", nullable = false) })
	private Set<Solicitudes> solicitudeses;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "TECNOLOGIAS_CANDIDATO", joinColumns = { @JoinColumn(name = "ID_CANDIDATO", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "ID_TECNOLOGIA", nullable = false) })
	private Set<Tecnologias> tecnologiass1;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "idCandidato")
	@XmlTransient
	private Set<Contactos> contactoss;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "idCandidato")
	@XmlTransient
	private Set<IdiomasCandidato> idiomasCandidatoes;

	public Set<Contactos> getContactoss() {
		return this.contactoss;
	}

}

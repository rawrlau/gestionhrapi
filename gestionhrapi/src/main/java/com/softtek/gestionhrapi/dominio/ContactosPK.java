package com.softtek.gestionhrapi.dominio;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.roo.addon.entity.RooIdentifier;

@RooIdentifier(dbManaged = true)
public final class ContactosPK {

	@Column(name = "ID_CANDIDATO", nullable = false)
	private BigDecimal idCandidato;

	@XmlTransient
	public BigDecimal getIdCandidato() {
		return this.idCandidato;
	}
}

package com.softtek.gestionhrapi.dominio;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(versionField = "", table = "TECNOLOGIAS", schema = "FORMACION")
@RooDbManaged(automaticallyDelete = true)
@XmlRootElement(name = "infoTecnologias", namespace = "tecnologias")
@XmlType(name = "infoTecnologias", namespace = "tecnologias")
public class Tecnologias {
	@Id
	@SequenceGenerator(name = "SEQ_TECNOLOGIA", sequenceName = "SEQ_TECNOLOGIA", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TECNOLOGIA")
	@Column(name = "ID_TECNOLOGIA")
	private BigDecimal idTecnologia;

	public BigDecimal getIdTecnologia() {
		return idTecnologia;
	}

	public void setIdTecnologia(BigDecimal idTecnologia) {
		this.idTecnologia = idTecnologia;
	}

}

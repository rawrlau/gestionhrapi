package com.softtek.gestionhrapi.dominio;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(identifierType = ContactosPK.class, versionField = "", table = "CONTACTOS", schema = "FORMACION")
@RooDbManaged(automaticallyDelete = true)
@XmlRootElement(name = "infoContactos", namespace = "contactos")
@XmlType(name = "infoContactos", namespace = "contactos")
public class Contactos {

	public static List<Contactos> findContactosByCandidato(BigDecimal idCandidato) {
		return entityManager()
				.createQuery("SELECT o FROM Contactos o WHERE ID_CANDIDATO = :idCandidato", Contactos.class)
				.setParameter("idCandidato", idCandidato).getResultList();
	}

	public static long countContactoses() {
		return entityManager().createQuery("SELECT COUNT(*) FROM Contactos o", Long.class).getSingleResult();
	}
}

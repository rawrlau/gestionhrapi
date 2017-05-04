package com.softtek.gestionhrapi.dominio;


import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(identifierType = IdiomasCandidatoPK.class, versionField = "", table = "IDIOMAS_CANDIDATO", schema = "FORMACION")
@RooDbManaged(automaticallyDelete = true)
@XmlRootElement(name = "infoIdiomas", namespace = "idioma")
@XmlType(name = "infoIdiomas", namespace = "idioma")
public class IdiomasCandidato {

	public static long countIdiomasCandidatoes() {
		return entityManager().createQuery("SELECT COUNT(*) FROM IdiomasCandidato o", Long.class).getSingleResult();
	}

	public static List<IdiomasCandidato> findIdiomasCandidatoPorId(BigDecimal idCandidato) {
		return entityManager()
				.createQuery("SELECT o FROM IdiomasCandidato o WHERE ID_CANDIDATO =:idCandidato",
						IdiomasCandidato.class).setParameter("idCandidato", idCandidato).getResultList();
	}
}

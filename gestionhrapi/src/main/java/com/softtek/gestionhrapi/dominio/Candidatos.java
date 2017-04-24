package com.softtek.gestionhrapi.dominio;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(versionField = "", table = "CANDIDATOS", schema = "FORMACION")
@RooDbManaged(automaticallyDelete = true)
public class Candidatos {
	
    @Id
    //@SequenceGenerator(name="sqcCandidato", sequenceName="SEQ_CANDIDATOS", allocationSize=1)
    //@GeneratedValue(strategy = GenerationType.AUTO, generator="sqcCandidato")
    @Column(name = "ID_CANDIDATO")
    private BigDecimal idCandidato;
}

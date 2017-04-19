// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.softtek.gestionhrapi.dominio;

import com.softtek.gestionhrapi.dominio.Tecnologias;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Tecnologias_Roo_Entity {
    
    declare @type: Tecnologias: @Entity;
    
    declare @type: Tecnologias: @Table(name = "TECNOLOGIAS", schema = "FORMACION");
    
    @PersistenceContext
    transient EntityManager Tecnologias.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_TECNOLOGIA")
    private BigDecimal Tecnologias.idTecnologia;
    
    public BigDecimal Tecnologias.getIdTecnologia() {
        return this.idTecnologia;
    }
    
    public void Tecnologias.setIdTecnologia(BigDecimal id) {
        this.idTecnologia = id;
    }
    
    @Transactional
    public void Tecnologias.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Tecnologias.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Tecnologias attached = Tecnologias.findTecnologias(this.idTecnologia);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Tecnologias.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Tecnologias.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Tecnologias Tecnologias.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Tecnologias merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager Tecnologias.entityManager() {
        EntityManager em = new Tecnologias().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Tecnologias.countTecnologiases() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Tecnologias o", Long.class).getSingleResult();
    }
    
    public static List<Tecnologias> Tecnologias.findAllTecnologiases() {
        return entityManager().createQuery("SELECT o FROM Tecnologias o", Tecnologias.class).getResultList();
    }
    
    public static Tecnologias Tecnologias.findTecnologias(BigDecimal idTecnologia) {
        if (idTecnologia == null) return null;
        return entityManager().find(Tecnologias.class, idTecnologia);
    }
    
    public static List<Tecnologias> Tecnologias.findTecnologiasEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Tecnologias o", Tecnologias.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}

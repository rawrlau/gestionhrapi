// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.softtek.gestionhrapi.dominio;

import com.softtek.gestionhrapi.dominio.Candidatos;
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

privileged aspect Candidatos_Roo_Entity {
    
    declare @type: Candidatos: @Entity;
    
    declare @type: Candidatos: @Table(name = "CANDIDATOS", schema = "FORMACION");
    
    @PersistenceContext
    transient EntityManager Candidatos.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CANDIDATO")
    private BigDecimal Candidatos.idCandidato;
    
    public BigDecimal Candidatos.getIdCandidato() {
        return this.idCandidato;
    }
    
    public void Candidatos.setIdCandidato(BigDecimal id) {
        this.idCandidato = id;
    }
    
    @Transactional
    public void Candidatos.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Candidatos.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Candidatos attached = Candidatos.findCandidatos(this.idCandidato);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Candidatos.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Candidatos.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Candidatos Candidatos.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Candidatos merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager Candidatos.entityManager() {
        EntityManager em = new Candidatos().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Candidatos.countCandidatoses() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Candidatos o", Long.class).getSingleResult();
    }
    
    public static List<Candidatos> Candidatos.findAllCandidatoses() {
        return entityManager().createQuery("SELECT o FROM Candidatos o", Candidatos.class).getResultList();
    }
    
    public static Candidatos Candidatos.findCandidatos(BigDecimal idCandidato) {
        if (idCandidato == null) return null;
        return entityManager().find(Candidatos.class, idCandidato);
    }
    
    public static List<Candidatos> Candidatos.findCandidatosEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Candidatos o", Candidatos.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}

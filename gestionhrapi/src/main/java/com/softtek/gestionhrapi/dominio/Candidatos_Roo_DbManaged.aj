// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.softtek.gestionhrapi.dominio;

import java.lang.String;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

privileged aspect Candidatos_Roo_DbManaged {


    @Column(name = "NOMBRE", length = 50)
    @NotNull
    private String Candidatos.nombre;
    
    @Column(name = "APELLIDOS", length = 150)
    private String Candidatos.apellidos;
    
    @Column(name = "PROVINCIA", length = 20)
    @NotNull
    private String Candidatos.provincia;
    
    @Column(name = "PERFIL", length = 20)
    @NotNull
    private String Candidatos.perfil;
    
    @Column(name = "POSICION", length = 50)
    private String Candidatos.posicion;
    
    @Column(name = "EXPERIENCIA", length = 15)
    private String Candidatos.experiencia;
    
    @Column(name = "DISP_VIAJAR", length = 1)
    private String Candidatos.dispViajar;
    
    @Column(name = "DISP_RESIDENCIA", length = 1)
    private String Candidatos.dispResidencia;
    
    @Column(name = "DISP_INCORPORACION", length = 20)
    private String Candidatos.dispIncorporacion;
    
    @Column(name = "EXPECT_CONTRACTUAL", length = 20)
    @NotNull
    private String Candidatos.expectContractual;
    
    @Column(name = "EXPECT_ECONOMICA")
    @NotNull
    private BigDecimal Candidatos.expectEconomica;
    
    @Column(name = "FECHA_ENTREVISTA")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date Candidatos.fechaEntrevista;
    
    @Column(name = "FEEDBACK_SOURCING", length = 255)
    @NotNull
    private String Candidatos.feedbackSourcing;
    
    @Column(name = "FEEDBACK_TECNICO", length = 255)
    private String Candidatos.feedbackTecnico;
    
    @Column(name = "TECNICO_SELECCION", length = 50)
    @NotNull
    private String Candidatos.tecnicoSeleccion;
    
    @Column(name = "REFERENCIADO", length = 50)
    private String Candidatos.referenciado;
    
    @Column(name = "ESTADO", length = 20)
    private String Candidatos.estado;
    
    @Column(name = "CV_SOFTTEK", length = 255)
    private String Candidatos.cvSofttek;
    
    @Column(name = "CV_PERSONAL", length = 255)
    private String Candidatos.cvPersonal;
    
    @Column(name = "FECHA_CONTACTO")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date Candidatos.fechaContacto;
    
    @Column(name = "FECHA_ACTUALIZADO")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date Candidatos.fechaActualizado;
    

    public String Candidatos.getNombre() {
        return this.nombre;
    }
    
    public void Candidatos.setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String Candidatos.getApellidos() {
        return this.apellidos;
    }
    
    public void Candidatos.setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String Candidatos.getProvincia() {
        return this.provincia;
    }
    
    public void Candidatos.setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    public String Candidatos.getPerfil() {
        return this.perfil;
    }
    
    public void Candidatos.setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    public String Candidatos.getPosicion() {
        return this.posicion;
    }
    
    public void Candidatos.setPosicion(String posicion) {
        this.posicion = posicion;
    }
    
    public String Candidatos.getExperiencia() {
        return this.experiencia;
    }
    
    public void Candidatos.setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }
    
    public String Candidatos.getDispViajar() {
        return this.dispViajar;
    }
    
    public void Candidatos.setDispViajar(String dispViajar) {
        this.dispViajar = dispViajar;
    }
    
    public String Candidatos.getDispResidencia() {
        return this.dispResidencia;
    }
    
    public void Candidatos.setDispResidencia(String dispResidencia) {
        this.dispResidencia = dispResidencia;
    }
    
    public String Candidatos.getDispIncorporacion() {
        return this.dispIncorporacion;
    }
    
    public void Candidatos.setDispIncorporacion(String dispIncorporacion) {
        this.dispIncorporacion = dispIncorporacion;
    }
    
    public String Candidatos.getExpectContractual() {
        return this.expectContractual;
    }
    
    public void Candidatos.setExpectContractual(String expectContractual) {
        this.expectContractual = expectContractual;
    }
    
    public BigDecimal Candidatos.getExpectEconomica() {
        return this.expectEconomica;
    }
    
    public void Candidatos.setExpectEconomica(BigDecimal expectEconomica) {
        this.expectEconomica = expectEconomica;
    }
    
    public Date Candidatos.getFechaEntrevista() {
        return this.fechaEntrevista;
    }
    
    public void Candidatos.setFechaEntrevista(Date fechaEntrevista) {
        this.fechaEntrevista = fechaEntrevista;
    }
    
    public String Candidatos.getFeedbackSourcing() {
        return this.feedbackSourcing;
    }
    
    public void Candidatos.setFeedbackSourcing(String feedbackSourcing) {
        this.feedbackSourcing = feedbackSourcing;
    }
    
    public String Candidatos.getFeedbackTecnico() {
        return this.feedbackTecnico;
    }
    
    public void Candidatos.setFeedbackTecnico(String feedbackTecnico) {
        this.feedbackTecnico = feedbackTecnico;
    }
    
    public String Candidatos.getTecnicoSeleccion() {
        return this.tecnicoSeleccion;
    }
    
    public void Candidatos.setTecnicoSeleccion(String tecnicoSeleccion) {
        this.tecnicoSeleccion = tecnicoSeleccion;
    }
    
    public String Candidatos.getReferenciado() {
        return this.referenciado;
    }
    
    public void Candidatos.setReferenciado(String referenciado) {
        this.referenciado = referenciado;
    }
    
    public String Candidatos.getEstado() {
        return this.estado;
    }
    
    public void Candidatos.setEstado(String estado) {
        this.estado = estado;
    }
    
    public String Candidatos.getCvSofttek() {
        return this.cvSofttek;
    }
    
    public void Candidatos.setCvSofttek(String cvSofttek) {
        this.cvSofttek = cvSofttek;
    }
    
    public String Candidatos.getCvPersonal() {
        return this.cvPersonal;
    }
    
    public void Candidatos.setCvPersonal(String cvPersonal) {
        this.cvPersonal = cvPersonal;
    }
    
    public Date Candidatos.getFechaContacto() {
        return this.fechaContacto;
    }
    
    public void Candidatos.setFechaContacto(Date fechaContacto) {
        this.fechaContacto = fechaContacto;
    }
    
    public Date Candidatos.getFechaActualizado() {
        return this.fechaActualizado;
    }
    
    public void Candidatos.setFechaActualizado(Date fechaActualizado) {
        this.fechaActualizado = fechaActualizado;
    }
    
}

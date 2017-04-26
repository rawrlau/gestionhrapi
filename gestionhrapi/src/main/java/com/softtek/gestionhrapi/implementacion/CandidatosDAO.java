package com.softtek.gestionhrapi.implementacion;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import com.softtek.exception.GestionHrException;
import com.softtek.gestionhrapi.dominio.Candidatos;

public interface CandidatosDAO {

	public void createCandidato(Candidatos candidato) throws GestionHrException;
	
	public Candidatos readCandidato(BigDecimal idCandidato) throws GestionHrException;

	public void updateCandidato(Candidatos candidato) throws GestionHrException;

	public void deleteCandidato(BigDecimal idCandidato) throws GestionHrException;
}

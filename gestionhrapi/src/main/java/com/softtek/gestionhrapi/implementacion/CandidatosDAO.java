package com.softtek.gestionhrapi.implementacion;

import java.math.BigDecimal;


import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.softtek.exception.GestionHrException;
import com.softtek.gestionhrapi.dominio.Candidatos;
@Path("/CandidatosServiceREST/")
public interface CandidatosDAO {
	
	@PUT
	@Path("/candidatos")
	public void createCandidato(Candidatos candidato) throws GestionHrException;
	
	@GET
	@Path("/candidatos/{idCandidato}")
	public Candidatos readCandidato(@PathParam("idCandidato")BigDecimal idCandidato) throws GestionHrException;
	
	@POST
	@Path("/candidatos")
	public void updateCandidato(Candidatos candidato) throws GestionHrException;
	
	@DELETE
	@Path("/candidatos/{idCandidato}")
	public void deleteCandidato(@PathParam("idCandidato")BigDecimal idCandidato) throws GestionHrException;
}

package com.softtek.gestionhrapi.implementacion;

import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.softtek.exception.GestionHrException;
import com.softtek.gestionhrapi.dominio.Candidatos;

@Path("/CandidatosServiceREST/")
public interface CandidatosDAO {

	@PUT
	@Path("/candidatos/create")
	@Produces({ MediaType.APPLICATION_JSON })
	public void createCandidato(Candidatos candidato) throws GestionHrException;

	@GET
	@Path("/candidatos/get/{idCandidato}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Candidatos readCandidato(@PathParam("idCandidato") BigDecimal idCandidato) throws GestionHrException;

	@GET
	@Path("/candidatos/list")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Candidatos> readAllCandidatos() throws GestionHrException;

	@GET
	@Path("/candidatos/list/{max}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Candidatos> readAllCandidatos(@PathParam("max") int max) throws GestionHrException;

	@POST
	@Path("/candidatos/update")
	@Produces({ MediaType.APPLICATION_JSON })
	public void updateCandidato(Candidatos candidato) throws GestionHrException;

	@DELETE
	@Path("/candidatos/delete/{idCandidato}")
	@Produces({ MediaType.APPLICATION_JSON })
	public void deleteCandidato(@PathParam("idCandidato") BigDecimal idCandidato) throws GestionHrException;
}

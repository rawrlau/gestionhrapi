package com.softtek.gestionhrapi.dominio.interfaces;

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

import com.softtek.gestionhrapi.dominio.IdiomasCandidato;
import com.softtek.gestionhrapi.dominio.exception.GestionHrException;

@Path("/IdiomasCandidatoREST/")
public interface IdiomaCandidato {
	@PUT
	@Path("/IdiomasCandidato/")
	@Produces({ MediaType.APPLICATION_JSON })
	public void altaIdioma(String idioma, BigDecimal idCandidato, String descripcion, String Nivel)
			throws GestionHrException;

	@DELETE
	@Path("/IdiomasCandidato/{idCandidato}")
	public boolean bajaIdioma(String idioma, @PathParam("idCandidato") BigDecimal idCandidato, String descripcion,
			String Nivel) throws GestionHrException;

	@POST
	@Path("/IdiomasCandidato")
	public void modificarIdioma(String idioma, BigDecimal idCandidato, String descripcion, String Nivel)
			throws GestionHrException;

	@GET
	@Path("/IdiomasCandidato/lista")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<IdiomasCandidato> getIdiomas() throws GestionHrException;

	@GET
	@Path("/IdiomasCandidato/{idCandidato}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<IdiomasCandidato> getIdiomasById(@PathParam("idCandidato") BigDecimal idCandidato)
			throws GestionHrException;
}

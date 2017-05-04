package com.softtek.gestionhrapi.dominio.interfaces;

import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.softtek.gestionhrapi.dominio.Contactos;
import com.softtek.gestionhrapi.dominio.exception.GestionHrException;

@Path("/contactosREST/")
public interface Contactos_Dao {

	@PUT
	@Path("/contactos")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void altaContactos(BigDecimal idCandidato, String tipoContacto, String valor);

	@DELETE
	@Path("/contactos/{idCandidato,tipoContacto,valor}")
	public void bajaContactos(@PathParam("idCandidato") BigDecimal idCandidato,
			@PathParam("tipoContacto") String tipoContacto, @PathParam("valor") String valor);

	@GET
	@Path("/contactos/{idCandidato}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Contactos> consultarContactos(@PathParam("idCandidato") BigDecimal idCandidato)
			throws GestionHrException;

	@GET
	@Path("/contactos/lista")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Contactos> consultarTodosContactos();

}

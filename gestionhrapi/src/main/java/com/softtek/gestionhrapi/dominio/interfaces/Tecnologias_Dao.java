package com.softtek.gestionhrapi.dominio.interfaces;

import java.math.BigDecimal;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.softtek.gestionhrapi.dominio.Tecnologias;

@Path("/tecnologiasREST/")
public interface Tecnologias_Dao {

	@PUT
	@Path("/tecnologias")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public void altaTecnologia(String nombre, String descripcion);

	@DELETE
	@Path("/tecnologias/{idTecnologias}")
	public void borrarTecnologia(@PathParam("idTecnologias") BigDecimal idTecnologias);

	@POST
	@Path("/tecnologias")
	public void modificarTecnologia(String nombre, String descripcion, BigDecimal idTecnologias);

	@GET
	@Path("/tecnologias/{idTecnologias}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Tecnologias consultarTecnologia(@PathParam("idTecnologias") BigDecimal idTecnologias);
}

package com.softtek.gestionhrapi.dominio.interfaces;

import java.math.BigDecimal;
import java.util.List;

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
import com.softtek.gestionhrapi.dominio.exception.GestionHrException;

@Path("/tecnologiasREST/")
public interface Tecnologias_Dao {

	@PUT
	@Path("tecnologias")
	@Consumes({ MediaType.APPLICATION_JSON })
	public void altaTecnologia(Tecnologias tecno) throws GestionHrException;

	@DELETE
	@Path("tecnologias/{idTecnologias}")
	public void deleteTecnologia(BigDecimal idTecnologias);

	@GET
	@Path("tecnologias/{idTecnologias}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public Tecnologias readTecnologia(@PathParam("idTecnologias") BigDecimal idTecnologia) throws GestionHrException;

	@POST
	@Path("/tecnologias")
	public void updateTecnologia(Tecnologias tecno) throws GestionHrException;

	@GET
	@Path("/tecnologias/")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	public List<Tecnologias> listaTecnologias();

}

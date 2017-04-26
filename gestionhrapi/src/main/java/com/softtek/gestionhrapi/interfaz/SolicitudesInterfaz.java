package com.softtek.gestionhrapi.interfaz;

import java.math.BigDecimal;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.softtek.gestionhrapi.dominio.Solicitudes;
import com.softtek.gestionhrapi.exception.GestionhrException;

@Path("/SolicitudesREST/")
public interface SolicitudesInterfaz {
	
	@PUT
	@Path("/solicitud")
	public void altaSolicitudCompleta(Solicitudes solicitud) throws GestionhrException;
	
	@POST
	@Path("/solicitud")
	public void modificarSolicitud(Solicitudes solicitud) throws GestionhrException;
	
	@DELETE
	@Path("/solicitud/{idSolicitud}")
	public boolean eliminarSolicitud(@PathParam("idSolicitud") BigDecimal idSolicitud) throws GestionhrException;
	
	public long countSolicitudes();
	
	@GET
	@Path("/solicitud/{idSolicitud}")
	@Produces({ MediaType.APPLICATION_XML,
		MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
	public Solicitudes getSolicitud(@PathParam("idSolicitud") BigDecimal idSolicitud) throws GestionhrException;
	
	public boolean comprobarTipo(Solicitudes solicitud);

}

package com.softtek.gestionhrapi.dominio;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.softtek.gestionhrapi.exception.GestionhrException;
import com.softtek.gestionhrapi.interfaz.SolicitudesInterfaz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/applicationContext*.xml" } )
/* @Transactional (Obligatorio en Produccion)
 * Una transacción de base de datos es un conjunto de instrucciones que se ejecutan en bloque. 
 * Por ejemplo, hago una consulta, modifico un registro A en la base de datos y elimino un registro B. 
 * Si en alguna de estas instrucciones se produce un error todo el proceso se echa atrás. 
 * De esta manera si luego consulto la base de datos veré que el registro A no ha sido alterado. 
 * Este proceso de “tirar atrás” las instrucciones realizadas se le dice hacer un rollback, mientras que el 
 * proceso de confirmar todas las instrucciones en bloque una vez hemos visto que no se ha producido ningún 
 * error se le llama hacer un commit.
 */
public class TestProyecto {
	
	private I18nLog LOG = I18nLogFactory.getLogI18n(Solicitudes.class);
	
	/* @Autowired La funcionalidad tan importante como básica de esta anotación es resolver 
	 * mediante inyección las dependencias de un bean de Spring.
	 * Permite resolver la inyección de dependencias de los siguientes modos:
	 * En el constructor de la clase.
	 * En un atributo.
	 * En un metodo setter.
	 * En un metodo JavaConfig.
	 */
	
	@Autowired
	SolicitudesInterfaz solicitudDao;
	
	@Test
	public void testAltaSolicitudesCompleta() throws GestionhrException {
		
		LOG.info("Se añaden las solicitudes");
		long numAntesAlta = solicitudDao.countSolicitudes();
		Solicitudes solicitud = new Solicitudes();
		solicitud.setNombre("Hola 2");
		solicitud.setDescripcion("Hola 2");
		solicitud.setFechaRecibida(new Date(23/11/2012));
		solicitud.setCliente("Hola 2");
		solicitud.setBrm("Hola 2");
		solicitud.setAdm("Hola 2");
		solicitud.setPerfil("Hola 2");
		solicitud.setReqObligatorios("Hola 2");
		solicitud.setReqDeseables("Hola 2");
		solicitud.setIngles("Hola 2");
		solicitud.setViajar('V');
		solicitud.setGuardias('G');
		solicitud.setConsultorasContactadas("Hola 2");
		solicitud.setEstado("Hola 2");
		
		try{
		solicitudDao.altaSolicitudCompleta(solicitud);
		LOG.debug("Solicitud dada de alta");
		}catch(GestionhrException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		
		long numDespuesAlta = solicitudDao.countSolicitudes();
		assertEquals(numAntesAlta+1,numDespuesAlta);
		
	}
	
	@Test
	public void testBajaSolicitudes() throws GestionhrException {
		
		LOG.info("Se eliminan las solicitudes");
		boolean resultado = false;
		long numAntesBaja = solicitudDao.countSolicitudes();
		
		try{
		resultado = solicitudDao.eliminarSolicitud(new BigDecimal(360));
		LOG.debug("Solicitud dada de baja");
		}catch(GestionhrException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}
		
		long numDespuesBaja = solicitudDao.countSolicitudes();
		assertEquals(numAntesBaja-1,numDespuesBaja);
		assertEquals(resultado,true);
		
	}
	
	@Test
	public void testModificacionSolicitudes() throws GestionhrException {
		
			LOG.info("Se modifican las solicitudes");
			Solicitudes solicitud = Solicitudes.findSolicitudes(new BigDecimal(370));
			solicitud.setNombre("Modificacion");
			
			try{
			solicitudDao.modificarSolicitud(solicitud);
			LOG.debug("Solicitud modificada");
			}catch(GestionhrException e) {
				LOG.error(e.getMessage());
				e.printStackTrace();
			}
			
			Assert.assertEquals("Modificacion", solicitud.getNombre());
	}
	
	@Test
	public void testGetSolicitudes() {
		
		LOG.info("Se consultan las solicitudes");
		Solicitudes solicitud = Solicitudes.findSolicitudes(new BigDecimal(350));
        Assert.assertNotNull(solicitud);
        //Assert.assertTrue(result.getSimbolo().equals(SIMBOLO));
		
	}
	
	@Test(expected = GestionhrException.class)
	public void testGetSolicitudesNegativo() throws GestionhrException{
		
		//Solicitudes result = 
		solicitudDao.getSolicitud(new BigDecimal(-1));
        //Assert.assertNotNull(result);
        //Assert.assertTrue(result.getSimbolo().equals(SIMBOLO));
		
	}
	
	@Test
	public void testCountSolicitudes(){
		
		LOG.info("Se listan las solicitudes");
		System.out.println(solicitudDao.countSolicitudes());
	}
	
	
}

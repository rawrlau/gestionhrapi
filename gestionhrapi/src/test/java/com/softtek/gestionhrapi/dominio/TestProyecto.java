package com.softtek.gestionhrapi.dominio;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
@ContextConfiguration(locations = { "classpath:/META-INF/spring/applicationContext*.xml" })
/*
 * @Transactional (Obligatorio en Produccion) Una transacción de base de datos
 * es un conjunto de instrucciones que se ejecutan en bloque. Por ejemplo, hago
 * una consulta, modifico un registro A en la base de datos y elimino un
 * registro B. Si en alguna de estas instrucciones se produce un error todo el
 * proceso se echa atrás. De esta manera si luego consulto la base de datos veré
 * que el registro A no ha sido alterado. Este proceso de “tirar atrás” las
 * instrucciones realizadas se le dice hacer un rollback, mientras que el
 * proceso de confirmar todas las instrucciones en bloque una vez hemos visto
 * que no se ha producido ningún error se le llama hacer un commit.
 */
public class TestProyecto {

	private final I18nLog LOG = I18nLogFactory.getLogI18n(Solicitudes.class);
	Scanner entrada = new Scanner(System.in);
	/*
	 * @Autowired La funcionalidad tan importante como básica de esta anotación
	 * es resolver mediante inyección las dependencias de un bean de Spring.
	 * Permite resolver la inyección de dependencias de los siguientes modos: En
	 * el constructor de la clase. En un atributo. En un metodo setter. En un
	 * metodo JavaConfig.
	 */

	@Autowired
	SolicitudesInterfaz solicitudDao;

	@Test
	public void testAltaSolicitudesCompleta() {

		LOG.info("======== Alta de solicitud Completa (Test)========");
		long numAntesAlta = solicitudDao.countSolicitudes();
		LOG.debug("Numero de solicitudes antes del alta (Test): " + numAntesAlta);
		Solicitudes solicitud = new Solicitudes();
		solicitud.setNombre("Hola");
		solicitud.setDescripcion("Hola");
		solicitud.setFechaRecibida(new Date(23 / 11 / 2012));
		solicitud.setCliente("Hola");
		solicitud.setBrm("Hola");
		solicitud.setAdm("Hola");
		solicitud.setPerfil("Hola");
		solicitud.setReqObligatorios("Hola");
		solicitud.setReqDeseables("Hola");
		solicitud.setIngles("Hola");
		solicitud.setViajar("E");
		solicitud.setGuardias("G");
		solicitud.setConsultorasContactadas("Hola");
		solicitud.setEstado("Hola");

		solicitudDao.altaSolicitudCompleta(solicitud);
		LOG.debug("Solicitud dada de alta con el Id (Test): " + solicitud.getIdSolicitud());
		LOG.debug("Solicitud (Test): " + solicitud.toString());

		long numDespuesAlta = solicitudDao.countSolicitudes();
		LOG.debug("Numero de solicitudes despues del alta (Test): " + numDespuesAlta);
		LOG.info("=============================================");
		LOG.info("");

		assertEquals(numAntesAlta + 1, numDespuesAlta);

	}

	@Test
	public void testAltaSolicitudesCompletaError() {

		LOG.info("======== Alta de solicitud Error (Test)========");
		LOG.info("Se espera la excepcion (Test): JpaSystemException");
		long numAntesAlta = solicitudDao.countSolicitudes();
		LOG.debug("Numero de solicitudes antes del alta (Test): " + numAntesAlta);
		Solicitudes solicitud = new Solicitudes();
		solicitud.setNombre("Hola");
		solicitud.setDescripcion("Hola");
		solicitud.setFechaRecibida(new Date(23 / 11 / 2012));
		solicitud.setCliente("Hola");
		solicitud.setBrm("Hola");
		solicitud.setAdm("Hola");
		solicitud.setPerfil("Hola");
		solicitud.setReqObligatorios("Hola");
		solicitud.setReqDeseables("Hola");
		solicitud.setIngles("Hola");
		LOG.debug("Insertamos un String para forzar la excepcion en Viajar (Test): JpaSystemException");
		solicitud.setViajar("Viajar");
		solicitud.setGuardias("G");
		solicitud.setConsultorasContactadas("Hola");
		solicitud.setEstado("Hola");

		solicitudDao.altaSolicitudCompleta(solicitud);
		LOG.debug("No se ha podido dar de alta la solicitud (Test)");

		long numDespuesAlta = solicitudDao.countSolicitudes();
		LOG.debug("Numero de solicitudes despues del alta (Test): " + numDespuesAlta);
		LOG.info("=============================================");
		LOG.info("");

		assertEquals(numAntesAlta, numDespuesAlta);

	}

	@Test
	public void testBajaSolicitudes() {

		List<Solicitudes> lista = Solicitudes.findAllSolicitudeses();
		Solicitudes listaSolicitudes = lista.get(lista.size() - 1);
		int identificador = listaSolicitudes.getIdSolicitud().intValue();

		LOG.info("======== Baja de solicitud (Test)========");
		boolean resultado = false;
		long numAntesBaja = solicitudDao.countSolicitudes();
		LOG.debug("Numero de solicitudes antes de la baja (Test): " + numAntesBaja);

		resultado = solicitudDao.eliminarSolicitud(new BigDecimal(identificador));
		LOG.debug("Solicitud dada de baja (Test)");
		long numDespuesBaja = solicitudDao.countSolicitudes();
		LOG.debug("Numero de solicitudes despues de la baja (Test): " + numDespuesBaja);
		LOG.info("=============================================");
		LOG.info("");

		assertEquals(numAntesBaja - 1, numDespuesBaja);
		assertEquals(resultado, true);

	}

	@Test
	public void testModificacionSolicitudes() {

		List<Solicitudes> lista = Solicitudes.findAllSolicitudeses();
		Solicitudes listaSolicitudes = lista.get(lista.size() - 1);
		int identificador = listaSolicitudes.getIdSolicitud().intValue();

		LOG.info("======== Modificar solicitud (Test)========");
		Solicitudes solicitud = Solicitudes.findSolicitudes(new BigDecimal(identificador));
		LOG.debug("Solicitud antes de la modificacion (Test): " + solicitud.toString());
		LOG.debug("Se modifica ADM con : Prueba modificacion, (Test)");
		solicitud.setAdm("Prueba modificacion");

		solicitudDao.modificarSolicitud(solicitud);
		LOG.debug("Solicitud modificada (Test)");
		LOG.debug("Nombre modificado : " + solicitud.getAdm());
		LOG.debug("Solicitud despues de la modificacion : " + solicitud.toString());
		LOG.info("=============================================");
		LOG.info("");

		Assert.assertEquals("Prueba modificacion", solicitud.getAdm());
	}

	@Test
	public void testGetSolicitudesId() {

		List<Solicitudes> lista = Solicitudes.findAllSolicitudeses();
		Solicitudes listaSolicitudes = lista.get(lista.size() - 1);
		int identificador = listaSolicitudes.getIdSolicitud().intValue();

		LOG.info("======== Se consultan las solicitudes (Test)========");
		Solicitudes solicitud = Solicitudes.findSolicitudes(new BigDecimal(identificador));
		LOG.debug("Id de la solicitud a consultar (Test): " + identificador);
		LOG.debug("Solicitud encontrada : " + solicitud.toString());
		LOG.info("=============================================");
		LOG.info("");

		Assert.assertNotNull(solicitud);

	}

	@Test
	public void testGetSolicitudesNegativo() throws GestionhrException {

		LOG.info("======== Se consultan las solicitudes Error (Test)========");
		LOG.debug("Se espera la excepcion por introducir Id negativa (Test)");
		Solicitudes solicitud = solicitudDao.getSolicitud(new BigDecimal(-1));
		LOG.info("=============================================");
		LOG.info("");

		assertEquals(null, solicitud);

	}

	@Test
	public void testCountSolicitudes() {

		LOG.info("======== Se listan las solicitudes (Test)========");
		solicitudDao.countSolicitudes();
		LOG.debug("Numero de solicitudes (Test): " + solicitudDao.countSolicitudes());
		LOG.info("=============================================");
		LOG.info("");

		Assert.assertNotNull(solicitudDao.countSolicitudes());
	}
}

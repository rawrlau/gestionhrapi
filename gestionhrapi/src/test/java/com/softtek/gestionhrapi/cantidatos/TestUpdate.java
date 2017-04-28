package com.softtek.gestionhrapi.cantidatos;

import java.math.BigDecimal;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.softtek.exception.GestionHrException;
import com.softtek.gestionhrapi.dominio.Candidatos;
import com.softtek.gestionhrapi.implementacion.CandidatosDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/applicationContext*.xml" })
public class TestUpdate {

	@Autowired
	CandidatosDAO candidatoDAO;

	private Candidatos candidato;
	private BigDecimal idCandidato, expectEconomica;
	private String nombre, apellidos, provincia, perfil, posicion, experiencia,
			dispViajar, dispResidencia, dispIncorporacion, expectContractual,
			feedbackSourcing, feedbackTecnico, tecnicoSeleccion, referenciado,
			estado, cvSofttek, cvPersonal;
	private Date fechaEntrevista, fechaContacto, fechaActualizado;

	@Before
	public void init() throws GestionHrException {
		idCandidato = new BigDecimal(36);
		nombre = "Zidane";
		apellidos = "Martín";
		provincia = "Cáceres";
		perfil = "Programador";
		posicion = "Estático";
		experiencia = "Mucha";
		dispViajar = "N";
		dispResidencia = "S";
		dispIncorporacion = "S";
		expectContractual = "Hola";
		expectEconomica = new BigDecimal(23453234);
		fechaEntrevista = new Date();
		feedbackSourcing = "FS";
		feedbackTecnico = "FT";
		tecnicoSeleccion = "TS";
		referenciado = "Sí";
		estado = "Líquido";
		cvSofttek = "No";
		cvPersonal = "Sí";
		fechaContacto = new Date();
		fechaActualizado = new Date();
		candidato = candidatoDAO.readCandidato(idCandidato);
	}

	/**
	 * Se comprueba que el NOMBRE ha sido modificado correctamente.
	 */
	@Test
	public void testNombreOk() throws GestionHrException {
		candidato.setNombre(nombre);
		candidatoDAO.updateCandidato(candidato);
		Assert.assertEquals(candidato.getNombre(), nombre);
	}

	/**
	 * Se comprueba que el APELLIDO ha sido modificado correctamente.
	 */
	@Test
	public void testApellidoOk() throws GestionHrException {
		candidato.setApellidos(apellidos);
		candidatoDAO.updateCandidato(candidato);
		Assert.assertEquals(candidato.getApellidos(), apellidos);
	}

	/**
	 * Se comprueba que la PROVINCIA ha sido modificada correctamente.
	 */
	@Test
	public void testProvinciaOk() throws GestionHrException {
		candidato.setProvincia(provincia);
		candidatoDAO.updateCandidato(candidato);
		Assert.assertEquals(candidato.getProvincia(), provincia);
	}

	/**
	 * Se comprueba que el PERFIL ha sido modificado correctamente.
	 */
	@Test
	public void testPerfilOk() throws GestionHrException {
		candidato.setPerfil(perfil);
		candidatoDAO.updateCandidato(candidato);
		Assert.assertEquals(candidato.getPerfil(), perfil);
	}

	/**
	 * Se comprueba que la POSICION ha sido modificada correctamente.
	 */
	@Test
	public void testPosicionOk() throws GestionHrException {
		candidato.setPosicion(posicion);
		candidatoDAO.updateCandidato(candidato);
		Assert.assertEquals(candidato.getPosicion(), posicion);
	}

	/**
	 * Se comprueba que la EXPERIENCIA ha sido modificada correctamente.
	 */
	@Test
	public void testExperienciaOk() throws GestionHrException {
		candidato.setExperiencia(experiencia);
		candidatoDAO.updateCandidato(candidato);
		Assert.assertEquals(candidato.getExperiencia(), experiencia);
	}

	/**
	 * Se comprueba que la DISP_VIAJAR ha sido modificada correctamente.
	 */
	@Test
	public void testDispViajarOk() throws GestionHrException {
		candidato.setDispViajar(dispViajar);
		candidatoDAO.updateCandidato(candidato);
		Assert.assertEquals(candidato.getDispViajar(), dispViajar);
	}

	/**
	 * Se comprueba que la DISP_RESIDENCIA ha sido modificada correctamente.
	 */
	@Test
	public void testDispResidenciaOk() throws GestionHrException {
		candidato.setDispResidencia(dispResidencia);
		candidatoDAO.updateCandidato(candidato);
		Assert.assertEquals(candidato.getDispResidencia(), dispResidencia);
	}

	/**
	 * Se comprueba que la DISP_INCORPORACION ha sido modificada correctamente.
	 */
	@Test
	public void testDispIncorporacionOk() throws GestionHrException {
		candidato.setDispIncorporacion(dispIncorporacion);
		candidatoDAO.updateCandidato(candidato);
		Assert.assertEquals(candidato.getDispIncorporacion(), dispIncorporacion);
	}

	/**
	 * Se comprueba que la EXPECT_CONTRACTUAL ha sido modificada correctamente.
	 */
	@Test
	public void testExpectContractualOk() throws GestionHrException {
		candidato.setExpectContractual(expectContractual);
		candidatoDAO.updateCandidato(candidato);
		Assert.assertEquals(candidato.getExpectContractual(), expectContractual);
	}

	/**
	 * Se comprueba que la EXPECT_ECONOMICA ha sido modificada correctamente.
	 */
	@Test
	public void testExpectEconomicaOk() throws GestionHrException {
		candidato.setExpectEconomica(expectEconomica);
		candidatoDAO.updateCandidato(candidato);
		Assert.assertEquals(candidato.getExpectEconomica(), expectEconomica);
	}

	/**
	 * Se comprueba que la FECHA_ENTREVISTA ha sido modificada correctamente.
	 */
	@Test
	public void testFechaEntrevistaOk() throws GestionHrException {
		candidato.setFechaEntrevista(fechaEntrevista);
		candidatoDAO.updateCandidato(candidato);
		Assert.assertEquals(candidato.getFechaEntrevista(), fechaEntrevista);
	}

	/**
	 * Se comprueba que el FEEDBACK_SOURCING ha sido modificado correctamente.
	 */
	@Test
	public void testFedbackSourcingOk() throws GestionHrException {
		candidato.setFeedbackSourcing(feedbackSourcing);
		candidatoDAO.updateCandidato(candidato);
		Assert.assertEquals(candidato.getFeedbackSourcing(), feedbackSourcing);
	}

	/**
	 * Se comprueba que el FEEDBACK_TECNICO ha sido modificado correctamente.
	 */
	@Test
	public void testFedbackTecnicoOk() throws GestionHrException {
		;
		candidato.setFeedbackTecnico(feedbackTecnico);
		candidatoDAO.updateCandidato(candidato);
		Assert.assertEquals(candidato.getFeedbackTecnico(), feedbackTecnico);
	}

	/**
	 * Se comprueba que el TECNICO_SELECCION ha sido modificado correctamente.
	 */
	@Test
	public void testTecnicoSeleccionOk() throws GestionHrException {
		candidato.setTecnicoSeleccion(tecnicoSeleccion);
		candidatoDAO.updateCandidato(candidato);
		Assert.assertEquals(candidato.getTecnicoSeleccion(), tecnicoSeleccion);
	}

	/**
	 * Se comprueba que REFERENCIADO ha sido modificado correctamente.
	 */
	@Test
	public void testReferenciadoOk() throws GestionHrException {
		candidato.setReferenciado(referenciado);
		candidatoDAO.updateCandidato(candidato);
		Assert.assertEquals(candidato.getReferenciado(), referenciado);
	}

	/**
	 * Se comprueba que el ESTADO ha sido modificado correctamente.
	 */
	@Test
	public void testEstadoOk() throws GestionHrException {
		candidato.setEstado(estado);
		candidatoDAO.updateCandidato(candidato);
		Assert.assertEquals(candidato.getEstado(), estado);
	}

	/**
	 * Se comprueba que el CV_SOFTTEK ha sido modificado correctamente.
	 */
	@Test
	public void testCvSofttekOk() throws GestionHrException {
		candidato.setCvSofttek(cvSofttek);
		candidatoDAO.updateCandidato(candidato);
		Assert.assertEquals(candidato.getCvSofttek(), cvSofttek);
	}

	/**
	 * Se comprueba que el CV_PERSONAL ha sido modificado correctamente.
	 */
	@Test
	public void testCvPersonalOk() throws GestionHrException {
		candidato.setCvPersonal(cvPersonal);
		candidatoDAO.updateCandidato(candidato);
		Assert.assertEquals(candidato.getCvPersonal(), cvPersonal);
	}

	/**
	 * Se comprueba que el FECHA_CONTACTO ha sido modificado correctamente.
	 */
	@Test
	public void testFechaContactoOk() throws GestionHrException {
		candidato.setFechaContacto(fechaContacto);
		candidatoDAO.updateCandidato(candidato);
		Assert.assertEquals(candidato.getFechaContacto(), fechaContacto);
	}

	/**
	 * Se comprueba que el FECHA_ACTUALIZADO ha sido modificado correctamente.
	 */
	@Test
	public void testFechaActualizadoOk() throws GestionHrException {
		candidato.setFechaActualizado(fechaActualizado);
		candidatoDAO.updateCandidato(candidato);
		Assert.assertEquals(candidato.getFechaActualizado(), fechaActualizado);
	}
}
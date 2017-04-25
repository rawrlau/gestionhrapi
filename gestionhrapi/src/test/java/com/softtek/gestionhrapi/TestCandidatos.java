package com.softtek.gestionhrapi;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.softtek.gestionhrapi.dominio.Candidatos;
import com.softtek.gestionhrapi.dominio.CandidatosDAO;
import com.softtek.gestionhrapi.dominio.Contactos;
import com.softtek.gestionhrapi.dominio.IdiomasCandidato;
import com.softtek.gestionhrapi.dominio.Solicitudes;
import com.softtek.gestionhrapi.dominio.Tecnologias;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/applicationContext*.xml" })
public class TestCandidatos {

	@Autowired
	CandidatosDAO candidato;

	@Test
	public void testCountEntidad() {
		long contador = Candidatos.countCandidatoses();
		System.out.println("Número de candidatos: " + contador);
		Assert.assertNotNull(contador);
	}

	@Test
	public void testAltaCandidato() {

		long antes = Candidatos.countCandidatoses();

		Set<Solicitudes> solicitudes = new HashSet<Solicitudes>();
		Set<Tecnologias> tecnologiass1 = new HashSet<Tecnologias>();
		Set<Contactos> contactoss = new HashSet<Contactos>();
		Set<IdiomasCandidato> idiomasCandidatoes = new HashSet<IdiomasCandidato>();
		String nombre = "Alejandro";
		String apellido = "Grillo";
		String provincia = "Madrid";
		String perfil = "Analista";
		String posicion = "Senior";
		String experiencia = "Poca";
		String dispViajar = "S";
		String dispResidencia = "N";
		String dispIncorporacion = "S";
		String expContractual = "Ser el boss";
		BigDecimal expEconomica = new BigDecimal(99999999);
		Date fecha_entrevista = new Date();
		String feedbackSourcing = "FS";
		String feedbackTecnico = "FT";
		String tecnicoSeleccion = "Yo";
		String referenciado = "Mucho";
		String estado = "Solido";
		String cvSofttek = "Muy bien";
		String cvPersonal = "No tengo";
		Date fechaContacto = new Date();
		Date fechaActualizado = new Date();

		int result = candidato.altaCandidato(solicitudes, tecnologiass1,
				contactoss, idiomasCandidatoes, nombre, apellido, provincia,
				perfil, posicion, experiencia, dispViajar, dispResidencia,
				dispIncorporacion, expContractual, expEconomica,
				fecha_entrevista, feedbackSourcing, feedbackTecnico,
				tecnicoSeleccion, referenciado, estado, cvSofttek, cvPersonal,
				fechaContacto, fechaActualizado);

		System.out.println("Insertado: " + result);
		long despues = Candidatos.countCandidatoses();
		System.out.println(antes + " " + despues);
		Assert.assertEquals(antes + 1, despues);
	}

	@Test
	public void testBajaCandidato() {

		long antes = Candidatos.countCandidatoses();

		int result = candidato.bajaCandidato(new BigDecimal(17));

		System.out.println("DADO DE BAJA: " + result);

		long despues = Candidatos.countCandidatoses();
		System.out.println(antes + " " + despues);
		Assert.assertEquals(antes - 1, despues);
	}

	@Test
	public void testModificacionCandidato() {

		Candidatos candidatoMod = candidato.consultaCandidato(new BigDecimal(354));

		Set<Solicitudes> solicitudes = candidatoMod.getSolicitudeses();
		Set<Tecnologias> tecnologiass1 = candidatoMod.getTecnologiass1();
		Set<Contactos> contactoss = candidatoMod.getContactoss();
		Set<IdiomasCandidato> idiomasCandidatoes = candidatoMod.getIdiomasCandidatoes();
		String nombre = "Ronaldinho";
		String apellido = candidatoMod.getApellidos();
		String provincia = candidatoMod.getProvincia();
		String perfil = candidatoMod.getPerfil();
		String posicion = candidatoMod.getPosicion();
		String experiencia = candidatoMod.getExperiencia();
		String dispViajar = candidatoMod.getDispViajar();
		String dispResidencia = candidatoMod.getDispResidencia();
		String dispIncorporacion = candidatoMod.getDispIncorporacion();
		String expContractual = candidatoMod.getExpectContractual();
		BigDecimal expEconomica = candidatoMod.getExpectEconomica();
		Date fecha_entrevista = candidatoMod.getFechaEntrevista();
		String feedbackSourcing = candidatoMod.getFeedbackSourcing();
		String feedbackTecnico = candidatoMod.getFeedbackTecnico();
		String tecnicoSeleccion = candidatoMod.getTecnicoSeleccion();
		String referenciado = candidatoMod.getReferenciado();
		String estado = candidatoMod.getEstado();
		String cvSofttek = candidatoMod.getCvSofttek();
		String cvPersonal = candidatoMod.getCvPersonal();
		Date fechaContacto = candidatoMod.getFechaContacto();
		Date fechaActualizado = candidatoMod.getFechaActualizado();

		int result = ((CandidatosDAO) candidatoMod).modificacionCandidato(solicitudes,
				tecnologiass1, contactoss, idiomasCandidatoes, nombre,
				apellido, provincia, perfil, posicion, experiencia, dispViajar,
				dispResidencia, dispIncorporacion, expContractual,
				expEconomica, fecha_entrevista, feedbackSourcing,
				feedbackTecnico, tecnicoSeleccion, referenciado, estado,
				cvSofttek, cvPersonal, fechaContacto, fechaActualizado);

		System.out.println("Modificado: " + result);

		Assert.assertEquals(candidatoMod.getNombre(), "Ronaldinho");
	}
}
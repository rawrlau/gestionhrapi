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
		System.out.println("Número de candidatos ANTES: " + antes);
		
		Candidatos candidato = new Candidatos();

		candidato.setSolicitudeses(new HashSet<Solicitudes>());
		candidato.setTecnologiass1(new HashSet<Tecnologias>());
		candidato.setContactoss(new HashSet<Contactos>());
		candidato.setIdiomasCandidatoes(new HashSet<IdiomasCandidato>());
		candidato.setNombre("Alejandro");
		candidato.setApellidos("Grillo");
		candidato.setProvincia("Madrid");
		candidato.setPerfil("Analista");
		candidato.setPosicion("Senior");
		candidato.setExperiencia("Poca");
		candidato.setDispViajar("S");
		candidato.setDispResidencia("N");
		candidato.setDispIncorporacion("S");
		candidato.setExpectContractual("Ser el boss");
		candidato.setExpectEconomica(new BigDecimal(99999999));
		candidato.setFechaEntrevista(new Date());
		candidato.setFeedbackSourcing("FS");
		candidato.setFeedbackTecnico("FT");
		candidato.setTecnicoSeleccion("TS");
		candidato.setReferenciado("No");
		candidato.setEstado("Sólido");
		candidato.setCvSofttek("Muy bien");
		candidato.setCvPersonal("No tengo");
		candidato.setFechaContacto(new Date());
		candidato.setFechaActualizado(new Date());		

		int result = this.candidato.altaCandidato(candidato);
		System.out.println("Insertado: " + result);
		
		long despues = Candidatos.countCandidatoses();
		System.out.println("Número de candidatos DESPUÉS: " + despues);
		
		Assert.assertEquals(antes + 1, despues);
	}

	@Test
	public void testBajaCandidato() {

		long antes = Candidatos.countCandidatoses();
		System.out.println("Número de candidatos ANTES: " + antes);

		int result = candidato.bajaCandidato(new BigDecimal(17));

		System.out.println("DADO DE BAJA: " + result);

		long despues = Candidatos.countCandidatoses();
		System.out.println("Número de candidatos DESPUÉS: " + despues);
		
		Assert.assertEquals(antes - 1, despues);
	}

	//@Test
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

		//int result = this.candidato.modificacionCandidato(candidato);

		//System.out.println("Modificado: " + result);

		Assert.assertEquals(candidatoMod.getNombre(), "Ronaldinho");
	}
}
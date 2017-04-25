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

	//@Test
	public void testAltaCandidato() {

		long antes = Candidatos.countCandidatoses();
		System.out.println("Número de candidatos ANTES: " + antes);
		
		Candidatos candidatoAlta = new Candidatos();

		candidatoAlta.setSolicitudeses(new HashSet<Solicitudes>());
		candidatoAlta.setTecnologiass1(new HashSet<Tecnologias>());
		candidatoAlta.setContactoss(new HashSet<Contactos>());
		candidatoAlta.setIdiomasCandidatoes(new HashSet<IdiomasCandidato>());
		candidatoAlta.setNombre("Alejandro");
		candidatoAlta.setApellidos("Grillo");
		candidatoAlta.setProvincia("Madrid");
		candidatoAlta.setPerfil("Analista");
		candidatoAlta.setPosicion("Senior");
		candidatoAlta.setExperiencia("Poca");
		candidatoAlta.setDispViajar("S");
		candidatoAlta.setDispResidencia("N");
		candidatoAlta.setDispIncorporacion("S");
		candidatoAlta.setExpectContractual("Ser el boss");
		candidatoAlta.setExpectEconomica(new BigDecimal(99999999));
		candidatoAlta.setFechaEntrevista(new Date());
		candidatoAlta.setFeedbackSourcing("FS");
		candidatoAlta.setFeedbackTecnico("FT");
		candidatoAlta.setTecnicoSeleccion("TS");
		candidatoAlta.setReferenciado("No");
		candidatoAlta.setEstado("Sólido");
		candidatoAlta.setCvSofttek("Muy bien");
		candidatoAlta.setCvPersonal("No tengo");
		candidatoAlta.setFechaContacto(new Date());
		candidatoAlta.setFechaActualizado(new Date());		

		int result = candidato.altaCandidato(candidatoAlta);
		System.out.println("Insertado: " + result);
		
		long despues = Candidatos.countCandidatoses();
		System.out.println("Número de candidatos DESPUÉS: " + despues);
		
		Assert.assertEquals(antes + 1, despues);
	}

	//@Test
	public void testBajaCandidato() {

		long antes = Candidatos.countCandidatoses();
		System.out.println("Número de candidatos ANTES: " + antes);

		int result = candidato.bajaCandidato(new BigDecimal(18));

		System.out.println("DADO DE BAJA: " + result);

		long despues = Candidatos.countCandidatoses();
		System.out.println("Número de candidatos DESPUÉS: " + despues);
		
		Assert.assertEquals(antes - 1, despues);
	}

	//@Test
	public void testModificacionCandidato() {

		Candidatos candidatoMod = candidato.consultaCandidato(new BigDecimal(354));	
		candidatoMod.setApellidos("JUANCHO PANCHO");

		int result = candidato.modificacionCandidato(candidatoMod);
		System.out.println("Modificado: " + result);

		Assert.assertEquals(candidatoMod.getApellidos(), "JUANCHO PANCHO");
	}

	@Test
	public void testConsultaCandidato() {

		Candidatos candidatoCon = candidato.consultaCandidato(new BigDecimal(19));
		System.out.println(candidatoCon.toString());

		Assert.assertNotNull(candidatoCon);
	}
}
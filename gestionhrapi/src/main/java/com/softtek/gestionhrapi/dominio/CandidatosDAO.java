package com.softtek.gestionhrapi.dominio;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public interface CandidatosDAO {

	public int altaCandidato(Candidatos candidato);

	public int bajaCandidato(BigDecimal idCandidato);

	public int modificacionCandidato(Candidatos candidato);

	public Candidatos consultaCandidato(BigDecimal idCandidato);
}

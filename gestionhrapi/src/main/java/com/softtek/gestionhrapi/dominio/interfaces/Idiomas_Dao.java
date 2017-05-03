package com.softtek.gestionhrapi.dominio.interfaces;

import java.math.BigDecimal;

public interface Idiomas_Dao {
	public void altaIdioma(String idioma, BigDecimal idCandidato, String nivel, String descripcion);

	public void modificarIdioma(String idioma, BigDecimal idCandidato, String nivel, String descripcion);
}

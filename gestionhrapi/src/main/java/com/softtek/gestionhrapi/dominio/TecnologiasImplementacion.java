package com.softtek.gestionhrapi.dominio;

import org.springframework.stereotype.Component;

@Component
public class TecnologiasImplementacion implements TecnologiasInterfaz{
	
	public void altaTecnologias(String nombre, String descripcion) {
		
		Tecnologias test = new Tecnologias();
		test.setNombre(nombre);
		test.setDescripcion(descripcion);
		test.persist();
		
	}

}

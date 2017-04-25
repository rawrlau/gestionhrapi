package com.softtek.gestionhrapi.dominio;

import org.jfree.util.Log;
import org.springframework.stereotype.Component;

@Component
public class TecnologiasDAOImpl implements TecnologiasDAO {

	@Override
	public int altaTecnologia(String nombre, String descripcion) {
		try {
			Tecnologias tec = new Tecnologias();
			tec.setNombre(nombre);
			tec.setDescripcion(descripcion);
			tec.persist();
			Log.info("Alta de tecnología realizada con éxito.");

		} catch (Exception e) {
			Log.error("No ha sido posible realizar el alta de la tecnologia.");
			return 0; // Error
		}
		return 1; // OK
	}

}

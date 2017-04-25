package com.softtek.gestionhrapi.dominio;

import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(versionField = "", table = "SOLICITUDES", schema = "FORMACION")
@RooDbManaged(automaticallyDelete = true)
public class Solicitudes {
}

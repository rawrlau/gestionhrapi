// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.softtek.gestionhrapi.dominio;

import java.lang.String;

privileged aspect Contactos_Roo_ToString {
    
    public String Contactos.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("IdCandidato: ").append(getIdCandidato());
        return sb.toString();
    }
    
}

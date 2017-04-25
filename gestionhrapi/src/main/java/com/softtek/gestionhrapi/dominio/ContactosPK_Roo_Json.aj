// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.softtek.gestionhrapi.dominio;

import com.softtek.gestionhrapi.dominio.ContactosPK;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect ContactosPK_Roo_Json {
    
    public String ContactosPK.toJson() {
        return new JSONSerializer().exclude("*.class").serialize(this);
    }
    
    public static ContactosPK ContactosPK.fromJsonToContactosPK(String json) {
        return new JSONDeserializer<ContactosPK>().use(null, ContactosPK.class).deserialize(json);
    }
    
    public static String ContactosPK.toJsonArray(Collection<ContactosPK> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }
    
    public static Collection<ContactosPK> ContactosPK.fromJsonArrayToContactosPKs(String json) {
        return new JSONDeserializer<List<ContactosPK>>().use(null, ArrayList.class).use("values", ContactosPK.class).deserialize(json);
    }
    
}
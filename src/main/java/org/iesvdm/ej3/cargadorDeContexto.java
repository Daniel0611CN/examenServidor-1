package org.iesvdm.ej3;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class cargadorDeContexto {

    public static Map<String, String> cargador() throws NoSuchAlgorithmException {

        var credencialsAnnotaion = Login.class.getAnnotationsByType(Credencial.class);

        Map<String, String> aux = new HashMap<String, String>();

        for (Credencial credencial : credencialsAnnotaion) {
            aux.put(credencial.usuario(), credencial.hashPasswd());
        }

        return aux;
    }

}

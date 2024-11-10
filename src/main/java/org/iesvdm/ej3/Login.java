package org.iesvdm.ej3;

import lombok.Data;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Data
@Credencial(usuario = "usuario1", hashPasswd = "8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918")
@Credencial(usuario = "usuario2", hashPasswd = "ac9689e2272427085e35b9d3e3e8bed88cb3434828b43b86fc0596cad4c6e270")
public class Login {

    protected Map<String, String> map = new HashMap<>();

    public void login(Scanner sc) throws NoSuchAlgorithmException {

        System.out.print("Introduce un usuario: ");
        String usuario = sc.next();

        System.out.print("Introduce una contraseña: ");
        String pswd = sc.next();

        HashProcess hp1 = new HashProcess();

        if (!map.containsValue(usuario)) {
            map.put(usuario, pswd);

            Map<String, String> result = cargadorDeContexto.cargador();

            String auxiliar = hp1.hashPassword(pswd);
            boolean haEntrado = false;
            for (int i = 0; i < result.size(); i++) {
                if (result.values().stream().toList().get(i).equals(auxiliar) && result.keySet().stream().toList().get(i).equals(usuario))  {
                    System.out.println("\nACCESO CONCEDIDO");
                    System.out.println("Credenciales añadidas a la lista.");
                    haEntrado = true;
                }
                else if (i == result.size()-1 && !haEntrado) {
                    System.out.println("\nACCESO DENEGADO");
                    System.out.println("Las credenciales no existen");
                }
            }
        } else {
            System.out.println("\nACCESO DENEGADO");
            System.out.println("Las credenciales no existen");
        }

    }

}

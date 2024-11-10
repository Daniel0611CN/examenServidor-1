package org.iesvdm.ej3;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Repeatable(Credenciales.class)
public @interface Credencial {
    String usuario();
    String hashPasswd();
}

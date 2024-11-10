package org.iesvdm.ej3;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Credenciales {
    Credencial[] value();
}

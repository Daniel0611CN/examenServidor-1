package org.iesvdm.ej1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class testEjercicio1 {

    @Test
    public void test1() {
        // Prueba 1

        UtilEstadistica u1 = new UtilEstadistica();

        double[] numeros = {2, 9, 3};
        int scale = 3;
        RoundingMode mode = RoundingMode.HALF_EVEN;

        BigDecimal result = u1.media(numeros, scale, mode);

        Assertions.assertEquals(4.667d, result.doubleValue());
    }

    @Test
    public void test2() {
        // Prueba 2

        UtilEstadistica u2 = new UtilEstadistica();

        double[] numeros = {2, 9, 3};
        int scale = 0;
        RoundingMode mode = RoundingMode.UP;

        BigDecimal result = u2.media(numeros, scale, mode);

        Assertions.assertEquals(5, result.intValue());
    }


}

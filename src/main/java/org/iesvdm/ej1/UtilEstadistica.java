package org.iesvdm.ej1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UtilEstadistica {

    public static BigDecimal media(double[] x, int escala, RoundingMode redondeo) {

        BigDecimal media = new BigDecimal(0);

        for (int i = 0; i < x.length; i++) {
            media = media.add(BigDecimal.valueOf(x[i]));
        }

        media = media.divide(BigDecimal.valueOf(x.length), escala, redondeo);

        System.out.println("Media: " + media);

        return media;
    }

}

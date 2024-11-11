package org.iesvdm.ej2;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static <K, V> void main(String[] args) {
        Map<Integer, String> m1 = new HashMap<>();

        BiMap bm1 = new BiMap(m1);

        bm1.put(4, "2");
        bm1.put(1, "3");
        bm1.inv();

        bm1.forcePut(3, "3");
        bm1.put(4, "4");
        bm1.put(3, "4");

    }

}

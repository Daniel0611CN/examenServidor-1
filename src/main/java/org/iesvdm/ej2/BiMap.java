package org.iesvdm.ej2;

import lombok.Data;
import java.util.*;

@Data
public class BiMap<K, V> {

    private Map<K, V> mapa = new HashMap<>();

    public BiMap(Map<K, V> mapa) {
        this.mapa = mapa;
    }

    public void put(K key, V value) {
        if (!mapa.containsValue(value)) {
            if (mapa.containsKey(key)) {
                mapa.replace(key, value);
                System.out.println("Valor reemplazado -> " + mapa);
            } else {
                mapa.put(key, value);
                System.out.println("Clave y Valor añadidos al mapa -> " + mapa);
            }
        } else  {
            System.out.println("No puedes introducir ese valor, ya corresponde a una clave -> " + mapa);
        }
    }

    public void forcePut(K key, V value) {
        List<V> values = new ArrayList<>(mapa.values());

        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).equals(value)) {
                mapa.remove(mapa.keySet().stream().toList().get(i));
                mapa.put(key, value);
            }
        }

        System.out.println("Clave y Valor forzados al mapa -> " + mapa);
    }

    public void inv() {
        Map<V, K> m1 = new HashMap<>();

        Set<K> keys = mapa.keySet();
        List<K> keysList = new ArrayList<>(keys);
        List<V> values = new ArrayList<>();
        values.addAll(mapa.values());

        for (int i = 0; i < mapa.size(); i++) {
            m1.put(values.get(i), keysList.get(i));
        }

        System.out.println("Mapa Invertido -> " + m1);

    }

}

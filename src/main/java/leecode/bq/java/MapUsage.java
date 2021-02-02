package leecode.bq.java;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/6/21 8:57 PM
 */
public class MapUsage {

    public static void main(String[] args) {
        getOrDefault();
        orderedMap();
    }

    private static void getOrDefault() {
        Map<Integer, Integer> m1 = new HashMap();

        int[] a1 = {1, 2, 3, 4, 5};
        for (int v: a1) {
            m1.put(v, 1);
        }

        for (int i = 0; i < 10; i++) {
            m1.put(i, m1.getOrDefault(i, 0) + i);
        }
    }

    private static void orderedMap() {
        // HashMap is not ordered
        // LinkedHashMap is ordered
        Map<Integer, String> dict = new LinkedHashMap<>();
        dict.put(1, "One");
        dict.put(2, "Two");
        dict.put(3, "Three");
        dict.put(4, "Four");
        dict.put(5, "Five");

        for(Map.Entry<Integer, String> kv : dict.entrySet()) {
            System.out.println(kv.getKey() + ":" + kv.getValue());
        }

    }
}

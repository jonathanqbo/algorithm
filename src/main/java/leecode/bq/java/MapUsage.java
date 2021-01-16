package leecode.bq.java;

import java.util.HashMap;
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
}

package leecode.bq.java;

import java.util.*;

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
        useMapEntryAsKeyValuePair();
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

    private static void putIfAbsent() {
        Map<String, Set<String>> m1 = new HashMap<>();

        //
        m1.putIfAbsent("key1", new HashSet<>());
        m1.get("key1").add("value1");

        // above code is same as:
        if (!m1.containsKey("key1")) {
            m1.put("key1", new HashSet<>());
        }
        m1.get("key1").add("value1");
    }

    private static void computeIfAbsent() {
        // note: computeIfAbsent return the new value or existed value
        // putIfAbsent return former value (which is null if not existed before)

        Map<String, Set<String>> m1 = new HashMap<>();
        m1.computeIfAbsent("key1", key -> new HashSet<String>()).add("value1");
        m1.computeIfAbsent("key2", key -> new HashSet<String>()).add("value2");

        // same as:
        m1.putIfAbsent("key1", new HashSet<>());
        m1.get("key1").add("value1");
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

    private static void useMapEntryAsKeyValuePair() {
//        Map.Entry<String, Integer> pair = new AbstractMap.SimpleEntry<>("key1", 1);
        Map.Entry<String, Integer> pair = new HashMap.SimpleEntry<>("key1", 1);
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());
    }

    private static void createMap() {
        Map<Character, Character> map = Map.of('1', '1', '6', '9', '8', '8', '9', '6', '0', '0');
    }
}

package leecode.bq.java;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * <b> </b>
 *
 * TreeMap is implemented with Red-Black Tree
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/22/21 9:40 PM
 */
public class TreeMapUsage {

    public static void main(String[] args) {
        sort();
        higherceilingKey();
        submap();
    }

    private static void sort() {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 11);
        map.put(8, 88);
        map.put(6, 66);
        map.put(9, 99);

        for (int key: map.keySet()) {
            // ==> 1, 6, 8, 9
            System.out.println(key);
        }
    }

    private static void higherceilingKey() {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 11);
        map.put(8, 88);
        map.put(6, 66);
        map.put(9, 99);

        System.out.println(map.lowerKey(2)); // ==> 1
        System.out.println(map.higherKey(2)); // ==> 6

        System.out.println(map.floorKey(2)); // ==> 1
        System.out.println(map.ceilingKey(2)); // ==> 6

        // the difference between higherKey and ceilingKey
        System.out.println(map.higherKey(6)); // ==> 8
        System.out.println(map.ceilingKey(6)); // ==> 6

        // if no such key existed, return null
        Integer key = map.floorKey(0);
        System.out.println(key); // key is null
    }


    private static void submap() {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 11);
        map.put(2, 22);
        map.put(8, 88);
        map.put(6, 66);
        map.put(9, 99);
        map.put(5, 55);
        map.put(7, 77);

        //  include 2, exclude 6
        Map<Integer, Integer> submap = map.subMap(2, 6); // 2, 5
        submap.keySet().stream().forEach(System.out::println);

        // exclude 2, include 6
        Map<Integer, Integer> submap2 = map.subMap(2, false, 6, true); // 5, 6
        submap2.keySet().stream().forEach(System.out::println);
    }

}

package leecode.bq.java;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/5/21 11:21 PM
 */
public class HashSetUsage {

    public static void main(String[] args) {
        unionNIntersection();
        setToPrimitiveArray();
        removeDuplicateList();
    }

    private static void unionNIntersection() {
        Set<Integer> set1 = new HashSet<>();
        set1.addAll(Arrays.asList(1, 2, 3, 4, 5));

        Set<Integer> set2 = new HashSet<>();
        set2.addAll(Arrays.asList(4, 5, 6, 7, 8));

        // intersection: set1 && set2
        Set<Integer> set3 = new HashSet(set1);
        set3.retainAll(set2);
        System.out.println(set3);

        // union: set1 || set2
        Set<Integer> set4 = new HashSet(set1);
        set4.addAll(set2);
        System.out.println(set4);
    }

    private static void setToPrimitiveArray() {
        int[] ints = Set.of(1, 2, 3, 4, 5, 6).stream()
                .mapToInt(Integer::intValue)
                .toArray();

        System.out.println(IntStream.of(ints).boxed().collect(Collectors.toList()));
    }

    private static void removeDuplicateList() {
        Set<List<Integer>> set = new HashSet<>();
        set.add(Arrays.asList(1, 2, 3));
        set.add(Arrays.asList(1, 2, 3));
        set.add(Arrays.asList(1, 2, 3));
        set.add(Arrays.asList(1, 2, 3));

        List<Integer> l1 = new LinkedList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        set.add(l1);

        System.out.println("remove duplicated List in a set: " + set.size()); // size == 1
    }
}

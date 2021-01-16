package leecode.bq.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/31/20 9:32 PM
 */
public class ArrayUsage {

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5, 6};

        // copy: method 1
        int[] a2 = a1.clone();
        System.out.println(String.join(", ", IntStream.of(a2).mapToObj(String::valueOf).collect(Collectors.toList())));

        int[] a3 = Arrays.copyOf(a1, a1.length);
        System.out.println(String.join(", ", IntStream.of(a3).mapToObj(String::valueOf).collect(Collectors.toList())));

        int[] a4 = Arrays.copyOfRange(a1, 0, a1.length);
        System.out.println(String.join(", ", IntStream.of(a4).mapToObj(String::valueOf).collect(Collectors.toList())));


    }
}

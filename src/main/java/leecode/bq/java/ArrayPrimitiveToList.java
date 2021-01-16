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
 * Created on 1/2/21 1:23 PM
 */
public class ArrayPrimitiveToList {

    /**
     * primitive array cannot be converted to boxed Object List using Arrays.asList()
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5, 6};

        // Arrays.asList convert array as List<array>
        List<int[]> listOfArray = Arrays.asList(a1);

        // way 1: to convert to List<Integer>
        List<Integer> l1 = IntStream.of(a1).boxed().collect(Collectors.toList());

        // way 2:
        List<Integer> l2 = Arrays.stream(a1) // this is to create a IntStream
                .boxed()
                .collect(Collectors.toList());
    }

}

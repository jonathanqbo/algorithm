package leecode.bq.java;

import java.util.Arrays;

/**
 * <b> </b>
 *
 * Java already provides binary search.
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/2/21 12:45 AM
 */
public class BinarySearchUsage {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9};

        int index = Arrays.binarySearch(arr1, 3);
        System.out.println(index);

        index = Arrays.binarySearch(arr1, 2);
        System.out.println(index);

        index = Arrays.binarySearch(arr1, 0);
        System.out.println(index);

        index = Arrays.binarySearch(arr1, 10);
        System.out.println(index);
    }

}

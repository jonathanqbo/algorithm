package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/20/21 10:26 AM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q1213IntersectionofThreeSortedArrays {

    /**

     solution 1: 2 pointers

     ----------

     solution 2: 3 pointers

     KEY: the order is important

     arr1 compare with arr2
     arr2 compare with arr3

     */

    class Solution {

        public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
            List<Integer> result = new ArrayList<>();

            int p1 = 0, p2 = 0, p3 = 0;
            while (p1 < arr1.length && p2 < arr2.length && p3 < arr3.length) {
                int num1 = arr1[p1], num2 = arr2[p2], num3 = arr3[p3];

                if (num1 == num2 && num2 == num3) {
                    result.add(num1);
                    p1++;
                    p2++;
                    p3++;
                } else if (num1 < num2) { // after this: num1 >= num2
                    p1++;
                } else if (num2 < num3) { // after this: num2 >= num3
                    p2++;
                } else {
                    p3++;
                }
            }

            return result;
        }

    }


    class Solution2 {

        public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
            int[] sub = merge2(arr1, arr2);
            sub = merge2(sub, arr3);

            return IntStream.of(sub).boxed().collect(Collectors.toList());
        }

        private int[] merge2(int[] arr1, int[] arr2) {
            List<Integer> result = new ArrayList<>();

            int p1 = 0, p2 = 0;
            while (p1 < arr1.length && p2 < arr2.length) {
                int num1 = arr1[p1], num2 = arr2[p2];

                if (num1 < num2) {
                    p1++;
                } else if (num1 > num2) {
                    p2++;
                } else {
                    result.add(num1);

                    p1++;
                    p2++;
                }
            }

            int[] arr = new int[result.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = result.get(i);
            }

            return arr;
        }

    }
}

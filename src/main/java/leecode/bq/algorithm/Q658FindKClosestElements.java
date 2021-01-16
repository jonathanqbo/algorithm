package leecode.bq.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/2/21 1:10 PM
 */
public class Q658FindKClosestElements {

    /**
     * solution 1: binary search, then two pointers
     *
     * Runtime: 4 ms, faster than 63.09% of Java online submissions for Find K Closest Elements.
     * Memory Usage: 41.1 MB, less than 28.55% of Java online submissions for Find K Closest Elements.
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new LinkedList();
        if (arr.length <= k) {
            for (int v: arr)
                result.add(v);

            return result;
        }

        int left = 0, right = arr.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                left = mid;
                right = mid + 1;
                break;
            } else if (arr[mid] < x) {
                left = mid;
            } else {
                right = mid;
            }
        }

        for (int i = 0; i < k; i++) {
            if (left >= 0 && right < arr.length) {
                if (right < arr.length && x - arr[left] <= arr[right] - x) {
                    result.add(0, arr[left]);
                    left--;
                } else {
                    result.add(arr[right]);
                    right++;
                }
            } else if (left >= 0) {
                result.add(0, arr[left]);
                left--;
            } else if (right < arr.length) {
                result.add(arr[right]);
                right++;
            }
        }

        return result;
    }

    /**
     * solution 2: binary search by checking sliding window
     *
     * Runtime: 3 ms, faster than 96.24% of Java online submissions for Find K Closest Elements.
     * Memory Usage: 41.5 MB, less than 17.88% of Java online submissions for Find K Closest Elements.
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> result = new LinkedList();

        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;

            // left: the first one that
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        for (int i = left; i < left + k; i++)
            result.add(arr[i]);

        return result;
    }

    /**
     * solution 3: from official solution
     *
     * Runtime: 3 ms, faster than 96.24% of Java online submissions for Find K Closest Elements.
     * Memory Usage: 41.4 MB, less than 19.76% of Java online submissions for Find K Closest Elements.
     *
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements3(int[] arr, int k, int x) {
        List<Integer> result = new LinkedList();
        int n = arr.length;
        if (x <= arr[0]) {
            for (int i = 0; i < k; i++)
                result.add(arr[i]);

            return result;
        } else if (arr[n - 1] <= x) {
            for (int i = n - k; i < n; i++)
                result.add(arr[i]);

            return result;
        } else {
            int index = Arrays.binarySearch(arr, x);
            if (index < 0)
                index = -index - 1;
            int low = Math.max(0, index - k - 1), high = Math.min(arr.length - 1, index + k - 1);

            while (high - low > k - 1) {
                if (low < 0 || (x - arr[low]) <= (arr[high] - x))
                    high--;
                else if (high > arr.length - 1 || (x - arr[low] > (arr[high] - x)))
                    low++;
                else
                    System.out.println("unhandled case: " + low + " " + high);
            }

            for (int i = low; i < high + 1; i++)
                result.add(arr[i]);

            return result;
        }
    }

}

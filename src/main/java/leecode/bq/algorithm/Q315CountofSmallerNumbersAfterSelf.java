package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/16/21 10:33 PM
 */
public class Q315CountofSmallerNumbersAfterSelf {

    /**
     * solution: sort + binary search ==> exceed time limit
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> result = new LinkedList<>();
        result.addFirst(0);

        if (nums.length == 1) {
            return result;
        }

        // sort + binary search: exceed time limit
        for (int i = nums.length - 2; i >= 0; i--) {
            Arrays.sort(nums, i + 1, nums.length);
            int j = binarySearch(nums, i + 1, nums.length - 1, nums[i]);
            result.addFirst(j - i - 1);
        }

        return result;
    }

    private int binarySearch(int[] nums, int start, int end, int value) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < value) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        return start;
    }

    /**
     * solution 2: improve solution 1 doing binary search and inert together
     *
     * Runtime: 735 ms, faster than 5.04% of Java online submissions for Count of Smaller Numbers After Self.
     * Memory Usage: 55.8 MB, less than 19.65% of Java online submissions for Count of Smaller Numbers After Self.
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller2(int[] nums) {
        LinkedList<Integer> result = new LinkedList<>();

        List<Integer> tree = new ArrayList<>(nums.length);
        for (int i = nums.length - 1; i >= 0; i--) {
            int count = binaryTree(tree, nums[i]);
            result.addFirst(count);
        }

        return result;
    }

    private int binaryTree(List<Integer> tree, int value) {
        int start = 0, end = tree.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (tree.get(mid) < value) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        tree.add(start, value);

        return start;
    }

}

package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/23/20 7:41 PM
 */
public class Q35SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target)
                return i;
        }

        return nums.length;
    }

    public int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        if (nums[r] == target)
            return r;
        else if (nums[r] < target)
            return r + 1;

        while(l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }
        return r;
    }
}

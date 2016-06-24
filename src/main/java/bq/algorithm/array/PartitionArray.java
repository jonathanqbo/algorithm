package bq.algorithm.array;

public class PartitionArray {

	public int partitionArray(int[] nums, int k) {
	    if (nums == null || nums.length == 0) {
	    	return -1;
	    }
	    
	    int left = 0, right = nums.length - 1;
	    while (left < right) {
	    	if (nums[left] < k) {
	    		left++;
	    		continue;
	    	}
	    	
	    	if (left == nums.length) {
	    		return nums.length;
	    	}
	    	
	    	while (right > left && nums[right] >=k) {
	    		right--;
	    	}
	    	if (right == -1) {
	    		return -1;
	    	}
	    	
	    	if (left < right) {
	    		int tmp = nums[left];
	    		nums[left] = nums[right];
	    		nums[right] = tmp;
	    	}
	    }
	    
	    return left;
    }
	
}

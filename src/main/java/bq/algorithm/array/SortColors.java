package bq.algorithm.array;

public class SortColors {

	public void sortColors(int[] nums) {
		if (nums == null || nums.length < 2) {
			return;
		}
		
		int left = 0;
		int right = nums.length - 1;
		int i = 0;
		while (i <= right) {
			if (nums[i] == 0) {
				swap(nums, i, left);
				i++;
				left++;
			}
			else if (nums[i] == 1) {
				i++;
			}
			else {
				swap(nums, i, right);
				// No i++ here, because right value after swap has not been checked yet.
				// All left values is 0
//				i++;
				right--;
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
}

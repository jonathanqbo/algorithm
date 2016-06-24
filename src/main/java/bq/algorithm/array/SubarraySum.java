package bq.algorithm.array;

import java.util.ArrayList;
import java.util.HashMap;

public class SubarraySum {

	public ArrayList<Integer> subarraySum(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		
		ArrayList<Integer> result = new ArrayList<Integer>(2);
		HashMap<Integer, Integer> subsum2Index = new HashMap<>();
		int subsum = 0;
		for (int i = 0; i < nums.length; i++) {
			subsum = subsum + nums[i];
			
			if (subsum2Index.containsKey(subsum)) {
				result.add(subsum2Index.get(subsum));
				result.add(i);
				return result;
			}
			
			subsum2Index.put(subsum, i);
		}
		
		return null;
	}
	
}

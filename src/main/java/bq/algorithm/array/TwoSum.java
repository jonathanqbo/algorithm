package bq.algorithm.array;

import java.util.HashMap;

public class TwoSum {

	public int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> value2Index = new HashMap<>();
		
		for (int i = 0; i < numbers.length; i++) {
			int needValue = target - numbers[i];
			if (value2Index.containsKey(needValue)) {
				return new int[]{value2Index.get(needValue), i};
			}
			
			value2Index.put(numbers[i], i);
		}
		
		return new int[]{};
	}
	
}

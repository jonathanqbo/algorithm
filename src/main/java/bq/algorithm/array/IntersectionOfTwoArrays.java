package bq.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class IntersectionOfTwoArrays {
	
	public int[] intersection(int[] nums1, int[] nums2) {
//		return solution1(nums1, nums2);
		return solution2(nums1, nums2);
	}
	
	/**
	 * by hashSet
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	private int[] solution1(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null) {
			return null;
		}
		
		HashSet<Integer> set1 = new HashSet<>(nums1.length);
		for (int i = 0; i < nums1.length; i++) {
			set1.add(nums1[i]);
		}
		
		HashSet<Integer> resultSet = new HashSet<>(nums2.length);
		for (int i = 0; i < nums2.length; i++) {
			if (set1.contains(nums2[i])) {
				resultSet.add(nums2[i]);
			}
		}
		
		int[] result = new int[resultSet.size()];
		int i = 0;
		for (Integer val : resultSet) {
			result[i] = val;
			i++;
		}
		
		return result;
	}
	
	/**
	 * by sort & two pointers
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	private int[] solution2(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		List<Integer> resultList = new ArrayList<>();
		int i = 0, j = 0;
		Integer lastVal = null;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				if (lastVal == null || !lastVal.equals(nums1[i])) {
					resultList.add(nums1[i]);
				}
				i++;
				j++;
			}
			else if (nums1[i] < nums2[j]) {
				resultList.add(nums1[i]);
				lastVal = nums1[i];
				i++;
			}
			else {
				resultList.add(nums2[j]);
				lastVal = nums2[j];
				j++;
			}
		}
		
		int[] result = new int[resultList.size()];
		i = 0;
		for (Integer val : resultList) {
			result[i] = val;
			i++;
		}
		
		return result;
	}
	
}

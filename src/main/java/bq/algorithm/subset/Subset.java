package bq.algorithm.subset;

import java.util.ArrayList;
import java.util.Arrays;

public class Subset {

	public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        int[] values = Arrays.copyOf(nums, nums.length);
        Arrays.sort(values);
        
        ArrayList<Integer> path = new ArrayList<Integer>();
        subsetHelp(result, path, values, 0);

        return result;
    }

    private void subsetHelp(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, 
            int[] nums, int startPos){
        
		result.add(new ArrayList<Integer>(path));
		
		for (int i = startPos; i < nums.length; i++) {
			path.add(nums[i]);
			subsetHelp(result, path, nums, (i+1));
			path.remove(path.size() - 1);
		}
	}
	
}

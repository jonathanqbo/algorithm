package bq.algorithm.permutation;

import java.util.ArrayList;

public class Permutation {

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<>();
		if (nums == null) {
		   return results; 
		}
		
		ArrayList<Integer> path = new ArrayList<>();
		dfs(results, path, nums);
		
		return results;
	}

	private void dfs(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> path, ArrayList<Integer> nums) {
		if (path.size() == nums.size()) {
			results.add(new ArrayList<>(path));
		}
		
		
		for (int i = 0; i < nums.size(); i++) {
			if (path.contains(nums.get(i))) {
				continue;
			}
			
			path.add(nums.get(i));
			dfs(results, path, nums);
			path.remove(path.size() - 1);
		}
		
	}
	
	
}

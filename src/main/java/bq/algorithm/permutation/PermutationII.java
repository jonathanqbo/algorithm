package bq.algorithm.permutation;

import java.util.ArrayList;

public class PermutationII {

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<>();
		
		ArrayList<Integer> path = new ArrayList<>();
		boolean[] visited = new boolean[nums.size()];
		dfs(results, path, nums, visited);
		
		return results;
	}

	private void dfs(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> path, ArrayList<Integer> nums, boolean[] visited) {
		if (path.size() == nums.size()) {
			results.add(new ArrayList<>(path));
		}
		
		for (int i = 0; i < nums.size(); i++) {
			if (visited[i]) {
				continue;
			}
			
			visited[i] = true;
			path.add(nums.get(i));
			dfs(results, path, nums, visited);
			path.remove(path.size() - 1);
			visited[i] = false;
		}
		
	}
	
}

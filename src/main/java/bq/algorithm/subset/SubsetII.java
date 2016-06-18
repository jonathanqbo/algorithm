package bq.algorithm.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubsetII {
	
	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> sortedList = new ArrayList<Integer>(S);
        Collections.sort(sortedList);
        
        ArrayList<Integer> path = new ArrayList<Integer>();
        subsetHelp(result, path, sortedList, 0);

        return result;
    }

    private void subsetHelp(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, 
            ArrayList<Integer> sortedList, int startPos){
        
		result.add(new ArrayList<Integer>(path));
		
		for (int i = startPos; i < sortedList.size(); i++) {
			if (i != startPos && (sortedList.get(i).equals(sortedList.get(i -1 )))) {
				continue;
			}
			
			path.add(sortedList.get(i));
			subsetHelp(result, path, sortedList, (i+1));
			path.remove(path.size() - 1);
		}
	}
    
}

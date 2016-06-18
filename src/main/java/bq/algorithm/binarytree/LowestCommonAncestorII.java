package bq.algorithm.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorII {

	public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
            ParentTreeNode A,
            ParentTreeNode B) {
		List<ParentTreeNode> pathA = new ArrayList<>();
		ParentTreeNode node = A;
		while ( node.parent != null ) {
			pathA.add(0, node);
			node = node.parent;
		}
		
		List<ParentTreeNode> pathB = new ArrayList<>();
		node = B;
		while ( node.parent != null ) {
			pathB.add(0, node);
			node = node.parent;
		}
		
		ParentTreeNode ancestor = null;
		int length = Math.min(pathA.size(), pathB.size());
		for ( int i = 0; i < length; i++) {
			if ( pathA.get(i) == pathB.get(i) ) {
				ancestor = pathA.get(i);
			}
		}
		
		return ancestor;
	}
	
	class ParentTreeNode {
		public ParentTreeNode parent, left, right;
	}
	
}

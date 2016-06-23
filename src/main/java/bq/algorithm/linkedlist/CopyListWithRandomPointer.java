package bq.algorithm.linkedlist;

import java.util.HashMap;

public class CopyListWithRandomPointer {

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}
		
		HashMap<RandomListNode, RandomListNode> node2Node = new HashMap<>();
		
		RandomListNode dummy = new RandomListNode(0);
		
		RandomListNode curNode = head;
		// for LinkedList, always keep the PRE pointer.
		RandomListNode pre = dummy;
		while (curNode != null) {
			RandomListNode nodeCopy = null;
			if ( node2Node.containsKey(curNode)) {
				nodeCopy = node2Node.get(curNode);
			}
			else {
				nodeCopy = new RandomListNode(curNode.label);
				node2Node.put(curNode, nodeCopy);
			}
			
			RandomListNode randomNodeCopy = null;
			if (node2Node.containsKey(curNode.random)) {
				randomNodeCopy = node2Node.get(curNode.random);
			}
			else {
				randomNodeCopy = new RandomListNode(curNode.random.label);
				node2Node.put(curNode.random, randomNodeCopy);
			}
			nodeCopy.random = randomNodeCopy;
			
			curNode = curNode.next;
			pre.next = nodeCopy;
			pre = pre.next;
		}
		
		return dummy.next;
	
	}
	
}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};
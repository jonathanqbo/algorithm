package leecode.bq.algorithm;

import leecode.bq.TreeNode;

import java.util.*;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/28/20 2:19 PM
 */
public class Q236LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // it will 100% guarantee to have a common ancestor from root.
        return helper(root, p, q);
    }

    /**
     * lowest common ancestor or the node itself
     *
     * @param node
     * @param p
     * @param q
     * @return
     */
    private TreeNode helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return null;
        }
        if (node.val == p.val || node.val == q.val) {
            return node;
        }

        TreeNode left = helper(node.left, p, q);
        TreeNode right = helper(node.right, p, q);

        if (left != null && right != null) {
            return node;
        }

        return left != null ? left : right;
    }

    /**
     * solution 2: keep tracking node's parent
     *
     * Runtime: 9 ms, faster than 18.36% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     * Memory Usage: 40 MB, less than 94.28% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new ArrayDeque();
        Map<TreeNode, TreeNode> nodeToParent = new HashMap();

        stack.offerLast(root);
        nodeToParent.put(root, null);

        while (!nodeToParent.containsKey(p) || !nodeToParent.containsKey(q)) {
            TreeNode node = stack.pollLast();

            if (node.right != null) {
                stack.offerLast(node.right);
                nodeToParent.put(node.right, node);
            }
            if (node.left != null) {
                stack.offerLast(node.left);
                nodeToParent.put(node.left, node);
            }
        }

        Set<TreeNode> parentsP = new HashSet();
        TreeNode node = p;
        while (node != null) {
            parentsP.add(node);
            node = nodeToParent.get(node);
        }

        node = q;
        while (!parentsP.contains(node)) {
            node = nodeToParent.get(node);
        }

        return node;
    }


    /**
     * solution 3:
     * use InOrderTraversal to find path to the first matched node
     * then seach in child nodes and each parent node of the path;
     *
     * Runtime: 5 ms, faster than 35.35% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     * Memory Usage: 40.1 MB, less than 94.38% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode firstFound = null;
        TreeNode secondFound = null;

        LinkedList<TreeNode> stack = new LinkedList();
        // next node to be add into stack
        TreeNode nextNodeToStack = root;
        while (nextNodeToStack != null || !stack.isEmpty()) {
            boolean found = false;

            while (nextNodeToStack != null) {
                stack.addLast(nextNodeToStack);

                if (nextNodeToStack.val == p.val) {
                    firstFound = p;
                    secondFound = q;
                    found = true;
                    break;
                } else if (nextNodeToStack.val == q.val) {
                    firstFound = q;
                    secondFound = p;
                    found = true;
                    break;
                }

                nextNodeToStack = nextNodeToStack.left;
            }

            if (found) {
                break;
            }

            nextNodeToStack = stack.pollLast();
            nextNodeToStack = nextNodeToStack.right;
        }

        // search in child nodes of first found node
        LinkedList<TreeNode> stack2 = new LinkedList();
        stack2.offerLast(stack.peekLast());
        while(!stack2.isEmpty()) {
            TreeNode node = stack2.pollLast();
            if (node.val == secondFound.val) {
                return firstFound;
            }
            if (node.right != null)
                stack2.offerLast(node.right);
            if (node.left != null)
                stack2.offerLast(node.left);
        }

        // search parent nodes of first found node
        while(!stack.isEmpty()) {
            TreeNode former = stack.pollLast();
            TreeNode parent = stack.peekLast();

            // if parent's right node is in path, don't need to search it again
            if (parent.right == former) {
                continue;
            }
            // only need to search right children
            if (parent.right == null) {
                continue;
            }

            LinkedList<TreeNode> stack3 = new LinkedList();
            stack3.offerLast(parent.right);
            while(!stack3.isEmpty()) {
                TreeNode node = stack3.pollLast();
                if (node.val == secondFound.val) {
                    return parent;
                }

                if (node.right != null)
                    stack3.offerLast(node.right);
                if (node.left != null)
                    stack3.offerLast(node.left);
            }
        }

        return root;
    }

}

package leecode.bq.algorithm;

import leecode.bq.TreeNode;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:11 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q536ConstructBinaryTreefromString {

    public class Solution {

        int i = 0;

        public TreeNode str2tree(String s) {
            if (s == null || s.length() == 0) { return null; }
            return helper(s.toCharArray());
        }

        private TreeNode helper(char[] s) {
            // done
            if (i == s.length) { return null; }

            // extract number
            StringBuilder num = new StringBuilder();
            while (i < s.length && s[i] != '(' && s[i] != ')') { num.append(s[i]); i++; }

            // create new node
            TreeNode n = null;
            if (num.length() != 0) {
                n = new TreeNode(Integer.parseInt(num.toString()));
            }
            // check parenthesis type
            if (i < s.length && s[i] == '(') {
                // create left child node
                i++;
                n.left = helper(s);
                i++;

                if (i < s.length && s[i] == '(') {
                    // create right child node
                    i++;
                    n.right = helper(s);
                    i++;
                }
            }
            // if meets ')', return to parent node
            return n;
        }
    }

}

package leecode.bq.algorithm;

import leecode.bq.NodeWithParent;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/20/21 10:43 AM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q1650LowestCommonAncestorofaBinaryTreeIII {

    /**

     solution: two list intersaction point

     @see: 160. Intersection of Two Linked Lists
     https://leetcode.com/problems/intersection-of-two-linked-lists/submissions/

     */

    class Solution {

        public NodeWithParent lowestCommonAncestor(NodeWithParent p, NodeWithParent q) {
            NodeWithParent p1 = p;
            NodeWithParent q1 = q;

            while (p1 != q1) {
                p1 = p1.parent;
                q1 = q1.parent;

                if (p1 == null) {
                    p1 = q;
                }
                if (q1 == null) {
                    q1 = p;
                }
            }

            return p1;
        }

    }

}

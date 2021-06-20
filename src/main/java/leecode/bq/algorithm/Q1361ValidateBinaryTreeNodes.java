package leecode.bq.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/20/21 10:35 AM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q1361ValidateBinaryTreeNodes {

    /**

     solution: inbound degree to find root, and dfs/bfs to check all nodes connect

     1. to find root:
     only one node has inbound degree == 0,
     all others must have inbound degree == 1

     note: inbound degree = 0, there still could cycle existed

     2. dfs/bfs:
     the connected node amount == n

     */
    class Solution {

        public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
            // calculate inbound degree
            int[] inDegrees = new int[n];
            for (int i = 0; i < n; i++) {
                if (leftChild[i] != -1) {
                    inDegrees[leftChild[i]]++;
                }
                if (rightChild[i] != -1) {
                    inDegrees[rightChild[i]]++;
                }
            }

            // validate inbound degree
            int root = -1;
            for (int i = 0; i < inDegrees.length; i++) {
                if (inDegrees[i] == 0 && root != -1) {
                    return false;
                }
                if (inDegrees[i] > 1) {
                    return false;
                }

                if (inDegrees[i] == 0 && root == -1) {
                    root = i;
                }
            }
            if (root == -1) {
                return false;
            }

            //
            Set<Integer> visited = new HashSet<>();
            dfs(root,visited, leftChild, rightChild);

            return visited.size() == n;
        }

        private void dfs(int node, Set<Integer> visited, int[] leftChild, int[] rightChild) {
            if (node == -1) {
                return;
            }

            visited.add(node);

            dfs(leftChild[node], visited, leftChild, rightChild);
            dfs(rightChild[node], visited, leftChild, rightChild);
        }

    }

}

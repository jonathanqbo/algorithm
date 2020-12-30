package leecode.bq.algorithm;

import leecode.bq.TreeNode;

/**
 * <b> </b>
 *
 * Runtime: 5 ms, faster than 97.97% of Java online submissions for Serialize and Deserialize Binary Tree.
 * Memory Usage: 40.5 MB, less than 87.97% of Java online submissions for Serialize and Deserialize Binary Tree.
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/28/20 5:00 PM
 */
public class Q297SerializeAndDeserializeBinaryTree {

    private static final String NULL_VALUE = "null";
    private static final String DELIMITER = ",";

    public String serialize(TreeNode root) {
        if (root == null) {
            return NULL_VALUE;
        }

        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);

        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL_VALUE).append(DELIMITER);
            return;
        }

        sb.append(node.val).append(DELIMITER);
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty() || data.equals(NULL_VALUE)) {
            return null;
        }

        String[] values = data.split(DELIMITER);
        // index is single value,
        // using 1 size array to pass in recusion function call to keep increasing it
        int[] index = new int[1];
        index[0] = 0;
        return deserializeHelper(values, index);
    }

    private TreeNode deserializeHelper(String[] values, int[] index) {
        String value = values[index[0]];
        index[0]++;

        if (value.equals(NULL_VALUE)) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = deserializeHelper(values, index);
        node.right = deserializeHelper(values, index);

        return node;
    }

}

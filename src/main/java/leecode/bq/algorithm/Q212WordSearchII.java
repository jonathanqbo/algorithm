package leecode.bq.algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/15/21 5:10 PM
 */
public class Q212WordSearchII {

    private static final int[][] directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    /**
     * solution: backtracking + Trie
     *
     * Runtime: 1 ms, faster than 94.05% of Java online submissions for Word Search II.
     * Memory Usage: 37.2 MB, less than 87.57% of Java online submissions for Word Search II.
     *
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);

        List<String> result = new LinkedList<>();
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = board[i][j];
                if (!root.contains(c)) {
                    continue;
                }

                backtrack(board, root, i, j, result);
            }
        }

        return result;
    }

    private void backtrack(char[][] board, TrieNode parentNode, int row, int col, List<String> result) {
        char c = board[row][col];
        int n = board.length;
        int m = board[0].length;

        TrieNode node = parentNode.get(c);
        if (node == null) {
            return;
        }

        if (node.word != null) {
            result.add(node.word);
            // remove from trie to avoid get it again
            node.word = null;
        }

        board[row][col] = '#';
        for (int[] dir: directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m) {
                continue;
            }

            char c1 = board[newRow][newCol];
            if (!node.contains(c1)) {
                continue;
            }

            backtrack(board, node, newRow, newCol, result);
        }
        board[row][col] = c;

        // remove leaf after visited
        // KEY: improve timecost from 100 msto 1 ms
        if (node.isEmpty()) {
            parentNode.remove(c);
        }
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word: words) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!node.contains(c)) {
                    node.put(c, new TrieNode());
                }

                node = node.get(c);
            }

            node.word = word;
        }

        return root;
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;

        public boolean contains(char c) {
            return children.containsKey(c);
        }

        public TrieNode get(char c) {
            return children.get(c);
        }

        public void put(char c, TrieNode node) {
            children.put(c, node);
        }

        public void remove(char c) {
            children.remove(c);
        }

        public boolean isEmpty() {
            return children.isEmpty();
        }
    }

    /**
     * same performance with Map implementation
     */
    class TrieNode2 {
        TrieNode[] children = new TrieNode[26];
        String word = null;
        int size = 0;

        public boolean contains(char c) {
            int i = c - 'a';
            if (i < 0 || i >= 26 || children[c - 'a'] == null) {
                return false;
            }

            return true;
        }

        public TrieNode get(char c) {
            return children[c - 'a'];
        }

        public void put(char c, TrieNode node) {
            children[c - 'a'] = node;
            size++;
        }

        public void remove(char c) {
            children[c - 'a'] = null;
            size--;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

}

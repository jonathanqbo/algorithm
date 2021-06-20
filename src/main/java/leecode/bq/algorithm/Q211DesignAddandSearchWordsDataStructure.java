package leecode.bq.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/15/21 10:27 PM
 */
public class Q211DesignAddandSearchWordsDataStructure {

    /**
     * solution: Trie + DFS
     *
     * Runtime: 48 ms, faster than 54.78% of Java online submissions for Design Add and Search Words Data Structure.
     * Memory Usage: 49.2 MB, less than 97.86% of Java online submissions for Design Add and Search Words Data Structure.
     *
     */
    class WordDictionary {

        TrieNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }

            node.isWord = true;
        }

        public boolean search(String word) {
            return dfs(word, 0, root);
        }

        private boolean dfs(String word, int i, TrieNode node) {
            if (i == word.length()) {
                // NOTE: node always point to parent, so after the last char, node point to the last node
                return node.isWord;
            }

            char c = word.charAt(i);
            if (node.children.containsKey(c)) {
                return dfs(word, i + 1, node.children.get(c));
            } else if (c == '.') {
                for (TrieNode childNode: node.children.values()) {
                    if (dfs(word, i + 1, childNode)) {
                        return true;
                    }
                }
            }

            return false;
        }

        class TrieNode {
            Map<Character, TrieNode> children = new HashMap<>();
            boolean isWord = false;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

}

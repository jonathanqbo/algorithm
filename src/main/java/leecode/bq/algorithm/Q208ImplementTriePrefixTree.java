package leecode.bq.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/15/21 3:16 PM
 */
public class Q208ImplementTriePrefixTree {

    /**
     * Runtime: 28 ms, faster than 99.58% of Java online submissions for Implement Trie (Prefix Tree).
     * Memory Usage: 48.4 MB, less than 77.35% of Java online submissions for Implement Trie (Prefix Tree).
     */
    class Solution1 {
        TrieNode root = new TrieNode();

        /** Initialize your data structure here. */
        public Solution1() {

        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }

                node = node.children[c - 'a'];
            }

            node.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) {
                    return false;
                }

                node = node.children[c - 'a'];
            }

            return node != null && node.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (node.children[c - 'a'] == null) {
                    return false;
                }

                node = node.children[c - 'a'];
            }

            return true;
        }

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isEnd = false;
        }
    }

    /**
     * solution 2: refactor solution 1 a bit from readability perspective.
     *
     * Runtime: 35 ms, faster than 53.80% of Java online submissions for Implement Trie (Prefix Tree).
     * Memory Usage: 48.1 MB, less than 85.71% of Java online submissions for Implement Trie (Prefix Tree).
     *
     */
    class Solution2 {
        TrieNode root = new TrieNode();

        /** Initialize your data structure here. */
        public Solution2() {

        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (!node.contains(c)) {
                    node.put(c, new TrieNode());
                }

                node = node.get(c);
            }

            node.setEnd();
        }

        private TrieNode searchPrefixNode(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!node.contains(c)) {
                    return null;
                }

                node = node.get(c);
            }

            return node;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = searchPrefixNode(word);
            return node != null && node.isEnd();
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = searchPrefixNode(prefix);
            return node != null;
        }

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isEnd = false;

            public void put(char c, TrieNode node) {
                children[c - 'a'] = node;
            }

            public TrieNode get(char c) {
                return children[c - 'a'];
            }

            public boolean contains(char c) {
                return children[c - 'a'] != null;
            }

            public boolean isEnd() {
                return isEnd;
            }

            public void setEnd() {
                isEnd = true;
            }
        }

        /**
         * solution 2: Implement using Map
         */
        class TrieNodeUsingMap {
            Map<Character, TrieNode> children = new HashMap<>();
            boolean isEnd = false;

            public void put(char c, TrieNode node) {
                children.put(c, node);
            }

            public TrieNode get(char c) {
                return children.get(c);
            }

            public boolean contains(char c) {
                return children.containsKey(c);
            }

            public boolean isEnd() {
                return isEnd;
            }

            public void setEnd() {
                isEnd = true;
            }
        }
    }
}

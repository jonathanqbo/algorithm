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
 * Created on 2/14/21 10:25 PM
 */
public class Q425WordSquares {

    /**
     * solution: word by word top to bottom + backtracking
     * Key: the prefix for each step
     *
     * Runtime: 44 ms, faster than 61.86% of Java online submissions for Word Squares.
     * Memory Usage: 43.2 MB, less than 34.23% of Java online submissions for Word Squares.
     *
     * @param words
     * @return
     */
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new LinkedList<>();

        Map<String, List<String>> prefixTable = buildPrefixTable(words);

        for (String word: words) {
            LinkedList<String> square = new LinkedList<>();
            square.offer(word);
            backtrack(1, square, words, prefixTable, result);
        }

        return result;
    }

    private void backtrack(int step, LinkedList<String> square, String[] words, Map<String, List<String>> prefixTable, List<List<String>> result) {
        if (step == words[0].length()) {
            result.add(new LinkedList<>(square));
            return;
        }

        StringBuilder prefix = new StringBuilder();
        for (String word: square) {
            prefix.append(word.charAt(step));
        }

        List<String> candidates = prefixTable.get(prefix.toString());
        if (candidates == null) {
            return;
        }

        for (String candidate: candidates) {
            square.add(candidate);
            backtrack(step + 1, square, words, prefixTable, result);
            square.removeLast();
        }
    }

    private Map<String, List<String>> buildPrefixTable(String[] words) {
        int n = words[0].length();

        Map<String, List<String>> result = new HashMap<>();
        for (String word: words) {
            for (int i = 1; i <= n; i++) {
                String prefix = word.substring(0, i);
                result.putIfAbsent(prefix, new LinkedList<String>());
                result.get(prefix).add(word);
            }
        }

        return result;
    }


    /**
     * solution 2: Prefix Tree to replace Map in solution 1
     *
     * Runtime: 52 ms, faster than 43.40% of Java online submissions for Word Squares.
     * Memory Usage: 43.2 MB, less than 31.21% of Java online submissions for Word Squares.
     *
     * @param words
     * @return
     */
    public List<List<String>> wordSquares2(String[] words) {
        List<List<String>> result = new LinkedList<>();

        TrieNode trie = buildPrefixTree(words);

        for (String word: words) {
            LinkedList<String> square = new LinkedList<>();
            square.offer(word);
            backtrack(1, square, words, trie, result);
        }

        return result;
    }

    private void backtrack(int step, LinkedList<String> square, String[] words, TrieNode trie, List<List<String>> result) {
        if (step == words[0].length()) {
            result.add(new LinkedList<>(square));
            return;
        }

        StringBuilder prefix = new StringBuilder();
        for (String word: square) {
            prefix.append(word.charAt(step));
        }

        List<String> candidates = getCandidates(trie, prefix, words);

        for (String candidate: candidates) {
            square.add(candidate);
            backtrack(step + 1, square, words, trie, result);
            square.removeLast();
        }
    }

    private List<String> getCandidates(TrieNode trie, StringBuilder prefix, String[] words) {
        TrieNode node = trie;
        for (int i = 0; i < prefix.length(); i++) {
            node = node.children.getOrDefault(prefix.charAt(i), null);
            if (node == null) {
                return new LinkedList<String>();
            }
        }

        List<String> result = new LinkedList<>();
        for (Integer idx: node.words) {
            result.add(words[idx]);
        }

        return result;
    }

    private TrieNode buildPrefixTree(String[] words) {
        TrieNode root = new TrieNode();

        for (int j = 0; j < words.length; j++) {
            String word = words[j];
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                node.children.putIfAbsent(c, new TrieNode());
                node.children.get(c).words.add(j);

                node = node.children.get(c);
            }
        }

        return root;
    }


    static class TrieNode {
        // note: TreeNode could be value + List of child
        // here we want to find by value quickly, Map<value, child> is faster.
        Map<Character, TrieNode> children = new HashMap<>();
        List<Integer> words = new LinkedList<>();
    }

}

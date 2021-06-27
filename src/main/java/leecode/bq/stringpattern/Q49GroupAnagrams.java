package leecode.bq.stringpattern;

import java.util.*;

/**
 * <b> </b>
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/6/21 9:48 AM
 */
public class Q49GroupAnagrams {

    /**
    key: build string pattern then group by pattern

    two ways to build:
    1) char[], count each char amount, then convert to string. The pattern is:
    2) sort each word


    NOTE: the default char value in char[] is /u0000, char[i]++ = /u0001

    */
    class Solution {

        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> patternToStrs = new HashMap<>();

            for (String str : strs) {
                String pattern = buildPattern(str);
                patternToStrs.computeIfAbsent(pattern, k -> new ArrayList<>()).add(str);
            }

            return new ArrayList<>(patternToStrs.values());
        }

        private String buildPattern(String str) {
            char[] pattern = new char[26];

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                pattern[c - 'a']++;
            }

            return new String(pattern);
        }

    }

}

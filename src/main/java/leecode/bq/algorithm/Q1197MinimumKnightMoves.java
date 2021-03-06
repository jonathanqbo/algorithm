package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/28/21 11:00 PM
 */
public class Q1197MinimumKnightMoves {

    /**
     * solution: Bottom up BFS + Symmetric + Memory
     *
     * Runtime: 1287 ms, faster than 6.58% of Java online submissions for Minimum Knight Moves.
     * Memory Usage: 231.8 MB, less than 5.27% of Java online submissions for Minimum Knight Moves.
     *
     */
    static class Solution {
        static final int[][] DIRECTIONS = new int[][]{
                {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}
        };

        Set<String> visited = new HashSet<>();

        public int minKnightMoves(int x, int y) {
            // due to the symmetrey, only check the 1/4 (right-top) part of board
            x = Math.abs(x);
            y = Math.abs(y);

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {0, 0});
            visited.add(new StringBuilder().append(0).append('-').append(0).toString());
            int level = 0;
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    int[] cord = queue.poll();
                    int corX = cord[0];
                    int corY = cord[1];

                    if (corX == x && corY == y) {
                        return level;
                    }

                    for (int[] dir: DIRECTIONS) {
                        int nextCorX = corX + dir[0];
                        int nextCorY = corY + dir[1];
                        String key = new StringBuilder().append(nextCorX).append('-').append(nextCorY).toString();
                        if (!visited.contains(key) && nextCorX >= -1 && nextCorY >= -1) {
                            queue.offer(new int[] {nextCorX, nextCorY});
                            // KEY: add into queue right away to avoid duplicate in same level
                            // otherwise get Time Limit Exceeded
                            visited.add(key);
                        }
                    }
                }

                level++;
            }

            throw new IllegalArgumentException();
        }
    }

    /**
     * solution 2: Top down Recursion + Memory
     *
     * Runtime: 9 ms, faster than 95.81% of Java online submissions for Minimum Knight Moves.
     * Memory Usage: 38.7 MB, less than 90.60% of Java online submissions for Minimum Knight Moves.
     *
     */
    class Solution2 {
        public int minKnightMoves(int x, int y) {
            x = Math.abs(x);
            y = Math.abs(y);
            Map<String, Integer> memo = new HashMap<>();
            return helper(x, y, memo);
        }

        private int helper(int x, int y, Map<String, Integer> memo) {
            String key = new StringBuilder().append(x).append(":").append(y).toString();
            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            // KEY
            if (x + y == 0) {
                return 0;
            } else if (x + y == 2) {
                return 2;
            }

            int min = Math.min(helper(Math.abs(x - 1), Math.abs(y - 2), memo),
                    helper(Math.abs(x - 2), Math.abs(y - 1), memo)) + 1;
            memo.put(key, min);

            return min;
        }
    }

}

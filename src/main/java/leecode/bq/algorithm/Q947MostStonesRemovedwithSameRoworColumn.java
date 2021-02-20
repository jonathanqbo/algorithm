package leecode.bq.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/14/21 4:47 PM
 */
public class Q947MostStonesRemovedwithSameRoworColumn {

    static class solution1 {

        /**
         * solution 1: straightforward Union-Find
         *
         * Runtime: 29 ms, faster than 41.38% of Java online submissions for Most Stones Removed with Same Row or Column.
         * Memory Usage: 39.4 MB, less than 51.59% of Java online submissions for Most Stones Removed with Same Row or Column.
         *
         * @param stones
         * @return
         */
        public int removeStones(int[][] stones) {
            int n = stones.length;

            UnionFind uf = new UnionFind(n);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int[] stone1 = stones[i];
                    int[] stone2 = stones[j];
                    if (stone1[0] == stone2[0] || stone1[1] == stone2[1]) {
                        uf.union(i, j);
                    }
                }
            }

            return n - uf.count;
        }

        static class UnionFind {
            int[] parent;
            int[] rank;
            int count;

            public UnionFind(int size) {
                parent = new int[size];
                rank = new int[size];
                count = 0;

                for (int i = 0; i < size; i++) {
                    parent[i] = i;
                    count++;
                }
            }

            public int find(int x) {
                if (parent[x] != x) {
                    parent[x] = find(parent[x]);
                }

                return parent[x];
            }

            public boolean union(int x, int y) {
                int rootX = find(x);
                int rootY = find(y);

                if (rootX == rootY) {
                    return false;
                }

                if (rank[rootX] == rank[rootY]) {
                    parent[rootX] = rootY;
                    rank[rootY]++;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                }

                count--;
                return true;
            }
        }

    }

    static class solution2 {

        /**
         * solution 2: Union Find by Map + union row and col
         *
         * Runtime: 7 ms, faster than 93.74% of Java online submissions for Most Stones Removed with Same Row or Column.
         * Memory Usage: 38.9 MB, less than 91.26% of Java online submissions for Most Stones Removed with Same Row or Column.
         *
         * @param stones
         * @return
         */
        public int removeStones(int[][] stones) {
            // trick:
            UnionFind uf = new UnionFind();
            for (int[] stone: stones) {
                uf.union(stone[0], stone[1] + 10000);
            }

            return stones.length - uf.count;
        }

        static class UnionFind {
            Map<Integer, Integer> parent = new HashMap<>();
            int count = 0;


            public int find(int x) {
                // init if not existed
                if (parent.putIfAbsent(x, x) == null) {
                    count++;
                }

                if (parent.get(x) != x) {
                    parent.put(x, find(parent.get(x)));
                }

                return parent.get(x);
            }

            public boolean union(int x, int y) {
                Integer rootX = find(x);
                Integer rootY = find(y);

                if (rootX.equals(rootY)) {
                    return false;
                }

                parent.put(rootX, rootY);
                count--;
                return true;
            }
        }

    }

}

package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/15/21 10:45 PM
 */
public class Q351AndroidUnlockPatterns {

    int[][] validJumps = new int[10][10];
    boolean[] visited = new boolean[10];

    /**
     * solution: backtracking
     *
     * Runtime: 14 ms, faster than 60.82% of Java online submissions for Android Unlock Patterns.
     * Memory Usage: 35.6 MB, less than 78.68% of Java online submissions for Android Unlock Patterns.
     *
     * @param m
     * @param n
     * @return
     */
    public int numberOfPatterns(int m, int n) {
        buildValidJumps();

        int count = 0;
        // for (int num = 1; num <= 9; num++) {
        //     visited[num] = true;
        //     count += dfs(num, 1, m, n);
        //     visited[num] = false;
        // }

        count += dfs(1, 1, m, n) * 4;
        count += dfs(2, 1, m, n) * 4;
        count += dfs(5, 1, m, n);

        return count;
    }

    private int dfs(int curNum, int len, int m, int n) {
        if (len > n) {
            return 0;
        }

        int count = 0;
        if (len >= m) {
            count++;
        }

        visited[curNum] = true;
        for (int nextNum = 1; nextNum < 10; nextNum++) {
            if (visited[nextNum] || !isValidJump(curNum, nextNum)) {
                continue;
            }

            count += dfs(nextNum, len + 1, m, n);
        }
        visited[curNum] = false;

        return count;
    }

    private void buildValidJumps() {
        validJumps[1][3] = validJumps[3][1] = 2;
        validJumps[1][7] = validJumps[7][1] = 4;
        validJumps[1][9] = validJumps[9][1] = 5;
        validJumps[2][8] = validJumps[8][2] = 5;
        validJumps[3][7] = validJumps[7][3] = 5;
        validJumps[3][9] = validJumps[9][3] = 6;
        validJumps[4][6] = validJumps[6][4] = 5;
        validJumps[7][9] = validJumps[9][7] = 8;
    }

    private boolean isValidJump(int i1, int i2) {
        int midNum = validJumps[i1][i2];
        return midNum == 0 || visited[midNum];
    }

}

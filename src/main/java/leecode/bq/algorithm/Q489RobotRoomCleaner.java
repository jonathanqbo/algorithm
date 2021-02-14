package leecode.bq.algorithm;

import leecode.bq.Pair;

import java.util.HashSet;
import java.util.Set;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/13/21 5:28 PM
 */
public class Q489RobotRoomCleaner {

    // clockwise {row, col}: up, right, down, left
    private static final int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    // don't know grid size, so use Set datastructure
    private Set<Pair<Integer, Integer>> visited = new HashSet<>();

    private Robot robot;

    /**
     * solution: backtracking, maze solving: right-hand rule,
     *
     * Runtime: 3 ms, faster than 99.65% of Java online submissions for Robot Room Cleaner.
     * Memory Usage: 38.6 MB, less than 93.28% of Java online submissions for Robot Room Cleaner.
     *
     * @param robot
     */
    public void cleanRoom(Robot robot) {
        this.robot = robot;

        move(0, 0, 0);
    }

    private void move(int row, int col, int direction) {
        robot.clean();
        visited.add(new Pair(row, col));

        // 4 turns: 0:same direction, 1/2/3: turn right
        for (int i = 0; i < 4; i++) {
            int newDirection = (direction + i) % 4;
            int newRow = row + directions[newDirection][0];
            int newCol = col + directions[newDirection][1];

            if (!visited.contains(new Pair(newRow, newCol)) && robot.move()) {
                move(newRow, newCol, newDirection);
                goBack();
            }

            robot.turnRight();
        }
    }

    private void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    static class Robot {

        public void turnRight() {
        }

        public boolean move() {
            return true;
        }

        public void clean() {

        }
    }

}

package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/11/21 10:52 PM
 */
public class Q1041RobotBoundedInCircle {

    /**
     * solution 1: if robert move in circle: either
     * it goes back to 0,0 in one instruction
     * or
     * it doesn't fact north(origin direction) in one instruction
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Robot Bounded In Circle.
     * Memory Usage: 37.4 MB, less than 25.45% of Java online submissions for Robot Bounded In Circle.
     *
     * @param instructions
     * @return
     */
    public boolean isRobotBounded(String instructions) {
        // north, east, south, west
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0;
        int x = 0, y = 0;
        for (int i = 0; i < instructions.length(); i++) {
            char instruction = instructions.charAt(i);
            if (instruction == 'L') {
                // Trick: left/right move in loop
                direction = (direction + 3) % 4;
                // direction = direction - 1 < 0 ? 3 : direction - 1;
            } else if (instruction == 'R') {
                direction = (direction + 1) % 4;
                // direction = direction + 1 > 3 ? 0 : direction + 1;
            } else {
                x += directions[direction][0];
                y += directions[direction][1];
            }
        }

        return (x == 0 && y == 0) || direction != 0;
    }


    /**
     * solution 2: 4 instructions must go back to origin
     *
     * Runtime: 1 ms, faster than 29.24% of Java online submissions for Robot Bounded In Circle.
     * Memory Usage: 36.7 MB, less than 93.24% of Java online submissions for Robot Bounded In Circle.
     *
     * @param instructions
     * @return
     */
    public boolean isRobotBounded2(String instructions) {
        // north, east, south, west
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0;
        int x = 0, y = 0;

        //KEY: 4 loops has to be go back to origin if there is a circle
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < instructions.length(); i++) {
                char instruction = instructions.charAt(i);
                if (instruction == 'L') {
                    direction = direction - 1 < 0 ? 3 : direction - 1;
                } else if (instruction == 'R') {
                    direction = direction + 1 > 3 ? 0 : direction + 1;
                } else {
                    x += directions[direction][0];
                    y += directions[direction][1];
                }
            }
        }

        return (x == 0 && y == 0);
    }

}

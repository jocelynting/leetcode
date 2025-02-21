package hash;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0;
        int x = 0, y = 0;

        Set<String> set = new HashSet<>();
        for (int[] o : obstacles) {
            set.add(o[0] + "," + o[1]);
        }

        int distance = 0;

        for (int c : commands) {
            if (c == -1) {
                dir = (dir + 1) % 4;
            } else if (c == -2) {
                dir = (dir + 3) % 4;
            } else {
                for (int i = 0; i < c; i++) {
                    int curX = x + directions[dir][0];
                    int curY = y + directions[dir][1];

                    if (set.contains(curX + "," + curY)) {
                        break;
                    }
                    x = curX;
                    y = curY;
                    distance = Math.max(distance, x * x + y * y);
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        WalkingRobotSimulation solution = new WalkingRobotSimulation();
        int[] commands1 = {4, -1, 3};
        int[][] obstacles1 = {};
        System.out.println(solution.robotSim(commands1, obstacles1)); // Output: 25

        int[] commands2 = {4, -1, 4, -2, 4};
        int[][] obstacles2 = {{2, 4}};
        System.out.println(solution.robotSim(commands2, obstacles2)); // Output: 65
    }
}

package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RobotCollisions {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {

        int n = positions.length;
        Integer[] indices = new Integer[n];
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(
                indices,
                (lhs, rhs) -> Integer.compare(positions[lhs], positions[rhs]));

        for (int index : indices) {
            // Add right-moving robots to the stack
            if (directions.charAt(index) == 'R') {
                stack.push(index);
            } else {
                while (!stack.isEmpty() && healths[index] > 0) {
                    // Pop the top robot from the stack for collision check
                    int cur = stack.pop();

                    // Top robot survives, current robot is destroyed
                    if (healths[cur] > healths[index]) {
                        healths[cur] -= 1;
                        healths[index] = 0;
                        stack.push(cur);
                    } else if (healths[cur] < healths[index]) {
                        // Current robot survives, top robot is destroyed
                        healths[index] -= 1;
                        healths[cur] = 0;
                    } else {
                        // Both robots are destroyed
                        healths[index] = 0;
                        healths[cur] = 0;
                    }
                }
            }
        }

        // Collect surviving robots
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                result.add(healths[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RobotCollisions solution = new RobotCollisions();

        int[] positions1 = {3, 5, 2, 6};
        int[] healths1 = {10, 10, 15, 12};
        String directions1 = "RLRL";
        System.out.println(solution.survivedRobotsHealths(positions1, healths1, directions1));// Output: [14]

        int[] positions2 = {5, 4, 3, 2, 1};
        int[] healths2 = {2, 17, 9, 15, 10};
        String directions2 = "RRRRR";
        System.out.println(solution.survivedRobotsHealths(positions2, healths2, directions2));// Output: [2,17,9,15,10]

        int[] positions3 = {1, 2, 5, 6};
        int[] healths3 = {10, 10, 11, 11};
        String directions3 = "RLRL";
        System.out.println(solution.survivedRobotsHealths(positions3, healths3, directions3));// Output: []
    }
}



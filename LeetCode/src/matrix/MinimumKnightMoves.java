package matrix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumKnightMoves {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        int result = 0;
        int[][] directions = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                if (cur[0] == x && cur[1] == y) {
                    return result;
                }

                for (int[] dir : directions) {
                    int newX = cur[0] + dir[0];
                    int newY = cur[1] + dir[1];
                    String position = newX + "," + newY;
                    if (!visited.contains(position) && newX >= -1 && newY >= -1) {
                        queue.offer(new int[]{newX, newY});
                        visited.add(position);
                    }
                }
            }

            result++;
        }

        return -1;
    }

    public static void main(String[] args) {
        MinimumKnightMoves solution = new MinimumKnightMoves();

        System.out.println(solution.minKnightMoves(2, 1)); // Output: 1
        System.out.println(solution.minKnightMoves(5, 5)); // Output: 4
        System.out.println(solution.minKnightMoves(0, 0)); // Output: 0
        System.out.println(solution.minKnightMoves(3, 3)); // Output: 2
        System.out.println(solution.minKnightMoves(300, 0)); // Output: 150
    }
}

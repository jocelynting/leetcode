package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        int INF = Integer.MAX_VALUE;
        int rows = rooms.length, cols = rooms[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int distance = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : directions) {
                    int row = cur[0] + dir[0];
                    int col = cur[1] + dir[1];
                    if (row >= 0 && row < rows && col >= 0 && col < cols && rooms[row][col] == INF) {
                        rooms[row][col] = distance;
                        queue.offer(new int[]{row, col});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        WallsAndGates solution = new WallsAndGates();
        int INF = Integer.MAX_VALUE;
        int[][] rooms = {
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF}
        };

        solution.wallsAndGates(rooms);

        for (int[] row : rooms) {
            for (int val : row) {
                if (val == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(val + " ");
                }
            }
            System.out.println();
        }
        // Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
    }
}

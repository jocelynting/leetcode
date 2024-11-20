package graph.dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MazeII {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] distance = new int[m][n];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{start[0], start[1], 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int row = cur[0], col = cur[1], dist = cur[2];

            if (row == destination[0] && col == destination[1]) {
                return dist;
            }

            for (int[] dir : directions) {
                int r = row;
                int c = col;
                int d = 0;

                while (r + dir[0] >= 0 && r + dir[0] < m && c + dir[1] >= 0 && c + dir[1] < n && maze[r + dir[0]][c + dir[1]] == 0) {
                    d++;
                    r += dir[0];
                    c += dir[1];
                }

                if (dist + d < distance[r][c]) {
                    distance[r][c] = dist + d;
                    pq.offer(new int[]{r, c, dist + d});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        MazeII solution = new MazeII();
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = {0, 4};
        int[] destination = {4, 4};
        System.out.println(solution.shortestDistance(maze, start, destination));// Output: 12
    }
}

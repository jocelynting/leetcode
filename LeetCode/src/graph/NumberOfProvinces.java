package graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int result = 0;

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                result++;
                dfs(isConnected, i, visited);
//                bfs(isConnected, i, visited);
            }
        }

        return result;
    }

    private void dfs(int[][] isConnected, int index, boolean[] visited) {
        visited[index] = true;

        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[index][i] == 1 && !visited[i]) {
                dfs(isConnected, i, visited);
            }
        }
    }

    private void bfs(int[][] isConnected, int index, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        visited[index] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[cur][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        NumberOfProvinces solution = new NumberOfProvinces();
        int[][] isConnected1 = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(solution.findCircleNum(isConnected1)); // Output: 2

        int[][] isConnected2 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        System.out.println(solution.findCircleNum(isConnected2)); // Output: 3
    }
}

package graph;

import java.util.*;

public class ShortestDistanceAfterRoadAdditionQueriesI {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(i + 1);
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0], end = queries[i][1];
            graph.get(start).add(end);
            result[i] = bfs(graph, n);
        }
        return result;
    }

    private int bfs(List<List<Integer>> graph, int n) {
        boolean[] visited = new boolean[n];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        int steps = -1;
        int distance = 0;
        while (!queue.isEmpty() && distance == 0) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == n - 1) {
                    distance = steps;
                }
                for (int nei : graph.get(cur)) {
                    if (!visited[nei]) {
                        visited[nei] = true;
                        queue.offer(nei);
                    }
                }
            }
        }
        
        return steps;
    }

    public static void main(String[] args) {
        ShortestDistanceAfterRoadAdditionQueriesI solution = new ShortestDistanceAfterRoadAdditionQueriesI();
        int n1 = 5;
        int[][] queries1 = {{2, 4}, {0, 2}, {0, 4}};
        System.out.println(Arrays.toString(solution.shortestDistanceAfterQueries(n1, queries1)));// Output: [3,2,1]

        int n2 = 4;
        int[][] queries2 = {{0, 3}, {0, 2}};
        System.out.println(Arrays.toString(solution.shortestDistanceAfterQueries(n2, queries2)));// Output: [1,1]
    }
}

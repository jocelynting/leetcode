package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        boolean[] visited = new boolean[n];
        visited[source] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == destination) {
                return true;
            }

            for (int nei : graph.get(cur)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    queue.offer(nei);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        FindPathExistsInGraph solution = new FindPathExistsInGraph();
        int[][] edges1 = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println(solution.validPath(3, edges1, 0, 2)); // Output: true

        int[][] edges2 = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        System.out.println(solution.validPath(6, edges2, 0, 5)); // Output: false
    }
}

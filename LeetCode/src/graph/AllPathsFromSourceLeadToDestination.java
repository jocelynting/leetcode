package graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceLeadToDestination {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        int[] visited = new int[n];

        return dfs(graph, visited, source, destination);
    }

    private boolean dfs(List<List<Integer>> graph, int[] visited, int node, int destination) {
        if (visited[node] == 1) {
            return false;
        }

        if (visited[node] == 2) {
            return true;
        }

        if (graph.get(node).isEmpty()) {
            return node == destination;
        }

        visited[node] = 1;

        for (int nei : graph.get(node)) {
            if (!dfs(graph, visited, nei, destination)) {
                return false;
            }
        }

        visited[node] = 2;

        return true;
    }

    public static void main(String[] args) {
        AllPathsFromSourceLeadToDestination solution = new AllPathsFromSourceLeadToDestination();
        int[][] edges1 = {{0, 1}, {0, 2}};
        System.out.println(solution.leadsToDestination(3, edges1, 0, 2)); // Output: false

        int[][] edges2 = {{0, 1}, {0, 3}, {1, 2}, {2, 1}};
        System.out.println(solution.leadsToDestination(4, edges2, 0, 3)); // Output: false

        int[][] edges3 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        System.out.println(solution.leadsToDestination(4, edges3, 0, 3)); // Output: true
    }
}

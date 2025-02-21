package graph;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponentsInUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(graph, visited, i);
            }
        }

        return count;
    }

    private void dfs(List<List<Integer>> graph, boolean[] visited, int index) {
        visited[index] = true;
        for (int nei : graph.get(index)) {
            if (!visited[nei]) {
                dfs(graph, visited, nei);
            }
        }
    }

    public static void main(String[] args) {
        ConnectedComponentsInUndirectedGraph solution = new ConnectedComponentsInUndirectedGraph();

        int n1 = 5;
        int[][] edges1 = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(solution.countComponents(n1, edges1)); // Output: 2

        int n2 = 5;
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        System.out.println(solution.countComponents(n2, edges2)); // Output: 1

        int n3 = 4;
        int[][] edges3 = {{2, 3}, {1, 2}, {1, 3}};
        System.out.println(solution.countComponents(n3, edges3)); // Output: 2
    }
}

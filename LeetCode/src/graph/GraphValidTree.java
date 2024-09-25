package graph;

import java.util.*;

public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        return validTreeByBFS(n, edges);
//        return validTreeByDFS(n, edges);
    }

    private boolean validTreeByBFS(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int nei : graph.get(cur)) {
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    queue.offer(nei);
                }
            }
        }

        return visited.size() == n;
    }

    private boolean validTreeByDFS(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> visited = new HashSet<>();
        dfs(0, graph, visited);

        return visited.size() == n;
    }

    private void dfs(int node, List<List<Integer>> graph, Set<Integer> visited) {
        if (visited.contains(node)) {
            return;
        }

        visited.add(node);

        for (int nei : graph.get(node)) {
            dfs(nei, graph, visited);
        }
    }

    public static void main(String[] args) {
        GraphValidTree solution = new GraphValidTree();

        int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(solution.validTree(5, edges1)); // true

        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        System.out.println(solution.validTree(5, edges2)); // false
    }
}

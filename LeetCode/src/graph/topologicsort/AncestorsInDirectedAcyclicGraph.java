package graph.topologicsort;

import java.util.*;

public class AncestorsInDirectedAcyclicGraph {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);
            for (int neighbor : graph.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        List<Set<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestors.add(new HashSet<>());
        }

        for (int node : order) {
            for (int neighbor : graph.get(node)) {
                ancestors.get(neighbor).add(node);
                ancestors.get(neighbor).addAll(ancestors.get(node));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> ancestorList = new ArrayList<>(ancestors.get(i));
            Collections.sort(ancestorList);
            result.add(ancestorList);
        }

        return result;
    }

    public static void main(String[] args) {
        AncestorsInDirectedAcyclicGraph solution = new AncestorsInDirectedAcyclicGraph();

        int n1 = 8;
        int[][] edges1 = {{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {4, 6}};
        System.out.println(solution.getAncestors(n1, edges1)); // Output: [[], [], [], [0, 1], [0, 2], [0, 1, 3], [0, 1, 2, 3, 4], [2]]

        int n2 = 5;
        int[][] edges2 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {3, 4}};
        System.out.println(solution.getAncestors(n2, edges2)); // Output: [[], [0], [0], [0, 1, 2], [0, 1, 2, 3]]
    }
}

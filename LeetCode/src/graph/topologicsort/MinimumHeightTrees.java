package graph.topologicsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();

        if (n <= 2) {
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
            return result;
        }

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 1) {
                queue.offer(i);
            }
        }

        int count = n;
        while (count > 2) {
            int size = queue.size();
            count -= size;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int nei : graph.get(cur)) {
                    indegree[nei]--;
                    if (indegree[nei] == 1) {
                        queue.offer(nei);
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumHeightTrees solution = new MinimumHeightTrees();

        int[][] edges1 = {{1, 0}, {1, 2}, {1, 3}};
        int n1 = 4;
        System.out.println(solution.findMinHeightTrees(n1, edges1)); // Output: [1]

        int[][] edges2 = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        int n2 = 6;
        System.out.println(solution.findMinHeightTrees(n2, edges2)); // Output: [3, 4]

        int[][] edges3 = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {3, 5}, {3, 6}};
        int n3 = 7;
        System.out.println(solution.findMinHeightTrees(n3, edges3)); // Output: [2]
    }
}

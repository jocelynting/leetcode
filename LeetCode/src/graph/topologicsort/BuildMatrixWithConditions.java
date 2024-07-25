package graph.topologicsort;

import java.util.*;

public class BuildMatrixWithConditions {

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rows = topoSort(rowConditions, k);
        int[] cols = topoSort(colConditions, k);

        if (rows.length == 0 || cols.length == 0) {
            return new int[0][0];
        }

        int[][] maxtix = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (rows[i] == cols[j]) {
                    maxtix[i][j] = rows[i];
                }
            }
        }

        return maxtix;
    }

    private int[] topoSort(int[][] edges, int n) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n + 1];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] order = new int[n];
        int index = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            order[index] = cur;
            index++;
            n--;

            for (int nei : graph[cur]) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }

        return n == 0 ? order : new int[0];
    }

    public static void main(String[] args) {
        BuildMatrixWithConditions solution = new BuildMatrixWithConditions();

        int k1 = 3;
        int[][] rowConditions1 = {{1, 2}, {3, 2}};
        int[][] colConditions1 = {{2, 1}, {3, 2}};
        int[][] result1 = solution.buildMatrix(k1, rowConditions1, colConditions1);
        System.out.println(Arrays.deepToString(result1)); // Output: [[3, 0, 0], [0, 0, 1], [0, 2, 0]]

        int k2 = 3;
        int[][] rowConditions2 = {{1, 2}, {2, 3}, {3, 1}};
        int[][] colConditions2 = {{1, 2}, {2, 3}};
        int[][] result2 = solution.buildMatrix(k2, rowConditions2, colConditions2);
        System.out.println(Arrays.deepToString(result2)); // Output: [[]]

        int k3 = 4;
        int[][] rowConditions3 = {{1, 2}, {2, 3}};
        int[][] colConditions3 = {{1, 2}, {2, 3}};
        int[][] result3 = solution.buildMatrix(k3, rowConditions3, colConditions3);
        System.out.println(Arrays.deepToString(result3)); // Output: [[1, 0, 0, 0], [0, 4, 0, 0], [0, 0, 2, 0], [0, 0, 0, 3]]
    }
}

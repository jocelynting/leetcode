package graph.dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PathWithMaximumProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int u = edge[0], v = edge[1];
            double w = succProb[i];
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.offer(new Edge(start_node, 1.0));

        double[] distance = new double[n];
        distance[start_node] = 1.0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int u = cur.node;
            double w = cur.prob;

            if (u == end_node) {
                return w;
            }

            if (w < distance[u]) {
                continue;
            }

            for (Edge nei : graph.get(u)) {
                int v = nei.node;
                double d = nei.prob;
                double update = d * w;
                if (update > distance[v]) {
                    distance[v] = update;
                    pq.offer(new Edge(v, update));
                }
            }

        }

        return 0.0;
    }

    class Edge {
        int node;
        double prob;

        Edge(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

    public static void main(String[] args) {
        PathWithMaximumProbability solution = new PathWithMaximumProbability();
        int n1 = 3;
        int[][] edges1 = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb1 = {0.5, 0.5, 0.2};
        int start1 = 0;
        int end1 = 2;
        System.out.println(solution.maxProbability(n1, edges1, succProb1, start1, end1));
        // Output: 0.25

        int n2 = 3;
        int[][] edges2 = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb2 = {0.5, 0.5, 0.3};
        int start2 = 0;
        int end2 = 2;
        System.out.println(solution.maxProbability(n2, edges2, succProb2, start2, end2));
        // Output: 0.3

        int n3 = 3;
        int[][] edges3 = {{0, 1}};
        double[] succProb3 = {0.5};
        int start3 = 0;
        int end3 = 2;
        System.out.println(solution.maxProbability(n3, edges3, succProb3, start3, end3));
        // Output: 0.0
    }
}

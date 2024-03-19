package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
//    public int[] dijkstra(int[][] graph, int source) {
//        int n = graph.length;
//        int[] distance = new int[n];
//        boolean[] visited = new boolean[n];
//
//        for (int i = 0; i < n; i++) {
//            distance[i] = Integer.MAX_VALUE;
//        }
//
//        distance[source] = 0;
//
//        for (int i = 0; i < n - 1; i++) {
//            int u = minDistance(distance, visited);
//            visited[u] = true;
//
//            for (int v = 0; v < n; v++) {
//                if (!visited[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE && distance[u] + graph[u][v] < distance[v]) {
//                    distance[v] = distance[u] + graph[u][v];
//                }
//            }
//        }
//
//        return distance;
//    }
//
//    private int minDistance(int[] distance, boolean[] visited) {
//        int min = Integer.MAX_VALUE;
//        int minIndex = -1;
//
//        for (int i = 0; i < distance.length; i++) {
//            if (!visited[i] && distance[i] <= min) {
//                min = distance[i];
//                minIndex = i;
//            }
//        }
//
//        return minIndex;
//    }

    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public int[] dijkstra(int[][] graph, int source) {
        int n = graph.length;
        int[] distances = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        minHeap.offer(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int u = currentNode.vertex;
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 && distances[u] != Integer.MAX_VALUE && distances[u] + graph[u][v] < distances[v]) {
                    distances[v] = distances[u] + graph[u][v];
                    minHeap.offer(new Node(v, distances[v]));
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        Dijkstra solution = new Dijkstra();

        int[][] graph = {
            {0, 2, 0, 1, 0},
            {2, 0, 3, 0, 0},
            {0, 3, 0, 4, 0},
            {1, 0, 4, 0, 5},
            {0, 0, 0, 5, 0}
        };

        int[] distance = solution.dijkstra(graph, 0);
        for (int i = 0; i < distance.length; i++) {
            System.out.println("Vertex " + i + " is at distance " + distance[i]);
        }
    }
}

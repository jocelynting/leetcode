package graph.dijkstra;

import java.util.*;

public class Dijkstra {
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void dijkstra(int vertices, List<Edge> edges, int source) {
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{source, 0});

        Map<Integer, List<Edge>> adjacencyList = new HashMap<>();
        for (Edge edge : edges) {
            adjacencyList.putIfAbsent(edge.source, new ArrayList<>());
            adjacencyList.get(edge.source).add(edge);
        }

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int dist = current[1];

            if (dist > distances[u]) {
                continue;
            }

            List<Edge> adjEdges = adjacencyList.getOrDefault(u, new ArrayList<>());
            for (Edge edge : adjEdges) {
                int v = edge.destination;
                int newDist = dist + edge.weight;
                if (newDist < distances[v]) {
                    distances[v] = newDist;
                    pq.offer(new int[]{v, newDist});
                }
            }
        }

        // Print the shortest distances from source
        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + ": " + distances[i]);
        }
    }

    public static void main(String[] args) {
        int vertices = 4;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 6));
        edges.add(new Edge(0, 2, 1));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(2, 3, 1));

        int source = 0;
        dijkstra(vertices, edges, source);
    }
}

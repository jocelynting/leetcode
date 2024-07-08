package graph;

import java.util.Arrays;

public class BellmanFord {
    // 边的类
    static class Edge {
        int source, destination, weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // 图的类
    static class Graph {
        int V, E;
        Edge[] edges;

        Graph(int V, int E) {
            this.V = V;
            this.E = E;
            edges = new Edge[E];
        }

        void addEdge(int u, int v, int w, int index) {
            edges[index] = new Edge(u, v, w);
        }

        void bellmanFord(int src) {
            // Step 1: Initialize distances from src to all other vertices as INFINITE
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;

            // Step 2: Relax all edges |V| - 1 times.
            for (int i = 1; i < V; ++i) {
                for (int j = 0; j < E; ++j) {
                    int u = edges[j].source;
                    int v = edges[j].destination;
                    int weight = edges[j].weight;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                    }
                }
            }

            // Step 3: Check for negative-weight cycles.
            for (int j = 0; j < E; ++j) {
                int u = edges[j].source;
                int v = edges[j].destination;
                int weight = edges[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }
            }

            printArr(dist, V);
        }

        void printArr(int[] dist, int V) {
            System.out.println("Vertex Distance from Source");
            for (int i = 0; i < V; ++i) {
                System.out.println(i + "\t\t" + dist[i]);
            }
        }
    }

    public static void main(String[] args) {
        // nested for loop to find the shortest path
        int V1 = 6;
        int E1 = 6;

        Graph graph1 = new Graph(V1, E1);
        graph1.addEdge(0, 1, 1, 0);
        graph1.addEdge(0, 3, 1, 1);
        graph1.addEdge(1, 2, -5, 2);
        graph1.addEdge(1, 4, -2, 3);
        graph1.addEdge(2, 5, 2, 4);
        graph1.addEdge(4, 3, -1, 5);

        graph1.bellmanFord(0);

        // graph contains negative weight cycle
        int V2 = 5;
        int E2 = 9;

        Graph graph2 = new Graph(V2, E2);
        graph2.addEdge(0, 1, 1, 0);
        graph2.addEdge(0, 4, -3, 1);
        graph2.addEdge(1, 2, -1, 2);
        graph2.addEdge(1, 4, 1, 3);
        graph2.addEdge(2, 3, 1, 4);
        graph2.addEdge(2, 1, -1, 5);
        graph2.addEdge(3, 2, -1, 6);
        graph2.addEdge(3, 4, 1, 7);
        graph2.addEdge(4, 1, -1, 8);

        graph2.bellmanFord(0);
    }
}

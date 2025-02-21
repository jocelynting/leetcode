package graph.prim;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class PrimMST {
    static class Edge {
        int source, destination, weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Node {
        int vertex, key;

        Node(int vertex, int key) {
            this.vertex = vertex;
            this.key = key;
        }
    }

    static class Graph {
        int V;
        LinkedList<Edge>[] adjacencyList;

        Graph(int V) {
            this.V = V;
            adjacencyList = new LinkedList[V];
            for (int i = 0; i < V; ++i) {
                adjacencyList[i] = new LinkedList<>();
            }
        }

        void addEdge(int source, int destination, int weight) {
            Edge edge1 = new Edge(source, destination, weight);
            Edge edge2 = new Edge(destination, source, weight);
            adjacencyList[source].add(edge1);
            adjacencyList[destination].add(edge2);
        }
    }

    void primMST(Graph graph) {
        boolean[] mstSet = new boolean[graph.V];
        Node[] nodes = new Node[graph.V];
        int[] parent = new int[graph.V];

        for (int i = 0; i < graph.V; i++) {
            nodes[i] = new Node(i, Integer.MAX_VALUE);
            parent[i] = -1;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(graph.V, Comparator.comparingInt(o -> o.key));

        nodes[0].key = 0;
        pq.add(nodes[0]);

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            mstSet[node.vertex] = true;

            for (Edge edge : graph.adjacencyList[node.vertex]) {
                if (!mstSet[edge.destination] && edge.weight < nodes[edge.destination].key) {
                    pq.remove(nodes[edge.destination]);
                    nodes[edge.destination].key = edge.weight;
                    pq.add(nodes[edge.destination]);
                    parent[edge.destination] = node.vertex;
                }
            }
        }

        System.out.println("Edges in MST");
        for (int i = 1; i < graph.V; i++) {
            System.out.println(parent[i] + " -- " + i + " == " + nodes[i].key);
        }
    }

    public static void main(String[] args) {
        PrimMST prim = new PrimMST();
        Graph graph = new Graph(5);

        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        prim.primMST(graph);
    }
}

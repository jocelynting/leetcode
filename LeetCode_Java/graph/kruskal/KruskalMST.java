package graph.kruskal;

import graph.unionfind.UnionFind;

import java.util.Arrays;
import java.util.Comparator;

class KruskalMST {

    static class Edge {
        int source, destination, weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int V, E;
        Edge[] edges;

        Graph(int V, int E) {
            this.V = V;
            this.E = E;
            edges = new Edge[E];
        }
    }

    void kruskalMST(Graph graph) {
        Edge[] result = new Edge[graph.V];
        int e = 0;

        Arrays.sort(graph.edges, Comparator.comparingInt(o -> o.weight));

        UnionFind uf = new UnionFind(graph.V);

        for (Edge nextEdge : graph.edges) {
            int x = uf.find(nextEdge.source);
            int y = uf.find(nextEdge.destination);

            if (x != y) {
                result[e++] = nextEdge;
                uf.union(x, y);
            }

            if (e == graph.V - 1) {
                break;
            }
        }

        System.out.println("Edges in MST:");
        for (int i = 0; i < e; ++i) {
            System.out.println(result[i].source + " -- " + result[i].destination + " == " + result[i].weight);
        }
    }

    public static void main(String[] args) {
        int V = 4;
        int E = 5;
        Graph graph = new Graph(V, E);

        graph.edges[0] = new Edge(0, 1, 10);
        graph.edges[1] = new Edge(0, 2, 6);
        graph.edges[2] = new Edge(0, 3, 5);
        graph.edges[3] = new Edge(1, 3, 15);
        graph.edges[4] = new Edge(2, 3, 4);

        KruskalMST mst = new KruskalMST();
        mst.kruskalMST(graph);
    }
}

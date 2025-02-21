package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        return bfs(node);
//        return dfs(node);
    }

    private Node bfs(Node node) {
        if (node == null) return null;

        Node clone = new Node(node.val);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        HashMap<Node, Node> visited = new HashMap<>();
        visited.put(node, clone);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (Node neighbor : current.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    Node cloneNeighbor = new Node(neighbor.val);
                    visited.put(neighbor, cloneNeighbor);
                    queue.offer(neighbor);
                }
                visited.get(current).neighbors.add(visited.get(neighbor));

            }
        }

        return clone;
    }

    private HashMap<Node,Node> visited = new HashMap<>();
    private Node dfs(Node node) {

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node clone = new Node(node.val);
        visited.put(node,clone);
        for (Node nei: node.neighbors) {
            clone.neighbors.add(dfs(nei));
        }

        return clone;
    }

    public static void main(String[] args) {
        CloneGraph solution = new CloneGraph();

        // Create a graph: [[2,4],[1,3],[2,4],[1,3]]
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // Clone the graph
        Node clonedGraph = solution.cloneGraph(node1);

        // Print the cloned graph
        System.out.println("Original graph:");
        printGraph(node1);

        System.out.println("\nCloned graph:");
        printGraph(clonedGraph);
    }

    private static void printGraph(Node node) {
        HashMap<Node, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        visited.put(node, true);
        queue.add(node);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.print(currentNode.val + " ");

            for (Node neighbor : currentNode.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, true);
                    queue.add(neighbor);
                }
            }
        }
    }
}

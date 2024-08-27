package binarytree;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }

        List<Node> children = node.children;
        for (Node n : children) {
            postorder(n, result);
        }

        result.add(node.val);
    }

    public static void main(String[] args) {
        NaryTreePostorderTraversal solution = new NaryTreePostorderTraversal();
        Node root = new Node(1, new ArrayList<>());
        Node child1 = new Node(3, new ArrayList<>());
        Node child2 = new Node(2, new ArrayList<>());
        Node child3 = new Node(4, new ArrayList<>());
        Node grandChild1 = new Node(5, new ArrayList<>());
        Node grandChild2 = new Node(6, new ArrayList<>());

        child1.children.add(grandChild1);
        child1.children.add(grandChild2);
        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);
        System.out.println(solution.postorder(root));  // Output: [5, 6, 3, 2, 4, 1]
    }
}

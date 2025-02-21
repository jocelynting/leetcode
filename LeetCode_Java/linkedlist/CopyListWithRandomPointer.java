package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    private Map<Node, Node> map;

    public Node copyRandomList(Node head) {
        map = new HashMap<>();
        return copyList(head);
    }

    private Node copyList(Node node) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node head = new Node(node.val);
        map.put(node, head);

        head.next = copyList(node.next);
        head.random = copyList(node.random);

        return head;
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer solution = new CopyListWithRandomPointer();

        Node node1 = solution.new Node(7);
        Node node2 = solution.new Node(13);
        Node node3 = solution.new Node(11);
        Node node4 = solution.new Node(10);
        Node node5 = solution.new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        Node head = solution.copyRandomList(node1);

        while (head != null) {
            System.out.println("Node: " + head.val + ", Random: " + (head.random != null ? head.random.val : "null"));
            head = head.next;
        }
    }
}

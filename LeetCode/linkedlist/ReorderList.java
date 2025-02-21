package linkedlist;

import java.util.Deque;
import java.util.LinkedList;

public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        Deque<ListNode> deque = new LinkedList<>();
        ListNode curr = head;

        while (curr != null) {
            deque.offerLast(curr);
            curr = curr.next;
        }

        curr = head;
        int size = deque.size();
        for (int i = 0; i < size / 2; i++) {
            ListNode node = deque.pollLast();
            ListNode next = curr.next;
            curr.next = node;
            node.next = next;
            curr = next;
        }

        curr.next = null;

    }

    public static void main(String[] args) {
        ReorderList solution = new ReorderList();

        // Test case 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        solution.reorderList(head);
        printList(head); // Expected output: [1,4,2,3]

        // Test case 2
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        solution.reorderList(head);
        printList(head); // Expected output: [1,5,2,4,3]
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}

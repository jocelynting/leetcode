package linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        ListNode node = head;


        Deque<ListNode> queue = new ArrayDeque<>();

        while (queue.size() < k){
            if (node == null){
                break;
            }
            queue.offerFirst(node);
            node = node.next;
            if (queue.size() == k) {
                while (!queue.isEmpty()) {
                    prev.next = queue.pollFirst();
                    prev = prev.next;
                }
            }
        }

        while (!queue.isEmpty()){
            prev.next = queue.pollLast();
            prev = prev.next;
        }

        prev.next = null;

        return dummy.next;
    }

//    public ListNode reverseKGroup(ListNode head, int k) {
//        if (head == null || k == 1) {
//            return head;
//        }
//
//        ListNode dummy = new ListNode(0,head);
//        ListNode prev = dummy;
//
//        int length = getLength(head);
//
//        for (int i = 0; i < length / k; i++) {
//            prev = reverseGroup(prev, k);
//        }
//
//        return dummy.next;
//    }
//
//    private int getLength(ListNode head) {
//        int length = 0;
//        while (head != null) {
//            length++;
//            head = head.next;
//        }
//        return length;
//    }
//
//    private ListNode reverseGroup(ListNode prev, int k) {
//        ListNode curr = prev.next;
//        ListNode next = null;
//        ListNode tail = prev.next;
//
//        for (int i = 0; i < k; i++) {
//            if (curr == null) {
//                // Not enough nodes to reverse, revert the changes and return
//                prev.next = tail;
//                return prev;
//            }
//
//            ListNode temp = curr.next;
//            curr.next = next;
//            next = curr;
//            curr = temp;
//        }
//
//        prev.next = next;
//        tail.next = curr;
//
//        return tail;
//    }

    // Example usage:
    public static void main(String[] args) {
        ReverseKGroup solution = new ReverseKGroup();

        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Reversing in groups of 2
        ListNode reversed = solution.reverseKGroup(head, 2);

        // Printing the result: 2 -> 1 -> 4 -> 3 -> 5
        while (reversed != null) {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        }
    }
}

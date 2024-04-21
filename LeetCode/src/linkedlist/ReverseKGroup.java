package linkedlist;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
//        return reverseKGroupByDeque(head, k);
        return reverseKGroupByListNode(head, k);
    }

    public ListNode reverseKGroupByListNode(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode cur = head;
        int count = 0;

        while (count < k && cur != null) {
            count++;
            cur = cur.next;
        }

        if (count == k) {
            ListNode reversedHead = reverseLinkedList(head, k);
            head.next = reverseKGroup(cur, k);
            return reversedHead;
        }

        return head;
    }

    private ListNode reverseLinkedList(ListNode head, int k) {
        ListNode next = null;
        ListNode cur = head;

        while (k > 0) {
            ListNode temp = cur.next;
            cur.next = next;
            next = cur;
            cur = temp;
            k--;
        }

        return next;
    }


    public ListNode reverseKGroupByDeque(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        ListNode node = head;

        Deque<ListNode> queue = new LinkedList<>();

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

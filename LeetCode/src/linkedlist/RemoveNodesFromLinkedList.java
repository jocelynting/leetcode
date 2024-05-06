package linkedlist;

import java.util.Stack;

public class RemoveNodesFromLinkedList {
    public ListNode removeNodes(ListNode head) {
        return removeNodesByLinkedList(head);
//        return removeNodesByStack(head);
    }

    private ListNode removeNodesByLinkedList(ListNode head) {
        ListNode reverse = reverse(head);

        ListNode cur = reverse.next;
        ListNode dummy = new ListNode(-1, reverse);

        while (cur != null) {
            if (cur.val >= reverse.val) {
                reverse.next = cur;
                reverse = reverse.next;
            }
            cur = cur.next;
        }

        reverse.next = null;

        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode node) {

        ListNode pre = null;
        ListNode cur = node;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    private ListNode removeNodesByStack(ListNode head) {
        if (head.next == null) {
            return head;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;

        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        cur = stack.pop();
        int max = cur.val;

        ListNode dummy = new ListNode(max);

        while (!stack.isEmpty()) {
            cur = stack.pop();

            if (cur.val < max) {
                continue;
            } else {
                ListNode node = new ListNode(cur.val);
                node.next = dummy;
                dummy = node;
                max = node.val;
            }
        }

        return dummy;
    }

    public static void main(String[] args) {
        RemoveNodesFromLinkedList solution = new RemoveNodesFromLinkedList();

        ListNode head1 = new ListNode(5);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(13);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(8);
        ListNode result1 = solution.removeNodes(head1);
        solution.printList(result1);// Output: [13,8]
    }

    public void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}

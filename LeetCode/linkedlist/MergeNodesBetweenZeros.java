package linkedlist;

public class MergeNodesBetweenZeros {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        head = head.next;
        int sum = 0;

        while (head != null) {

            if (head.val == 0) {
                cur.next = new ListNode(sum);
                cur = cur.next;
                sum = 0;
            } else {
                sum += head.val;
            }
            head = head.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeNodesBetweenZeros solution = new MergeNodesBetweenZeros();

        ListNode head1 = new ListNode(0, new ListNode(3, new ListNode(1, new ListNode(0, new ListNode(4, new ListNode(5, new ListNode(2, new ListNode(0))))))));
        ListNode result1 = solution.mergeNodes(head1);
        printList(result1); // Output: 4 -> 11

        ListNode head2 = new ListNode(0, new ListNode(1, new ListNode(0, new ListNode(3, new ListNode(0, new ListNode(2, new ListNode(2, new ListNode(0))))))));
        ListNode result2 = solution.mergeNodes(head2);
        printList(result2); // Output: 1 -> 3 -> 4
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}

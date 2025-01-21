package linkedlist;

public class DeleteMiddleNode {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }

        int middle = count / 2;
        cur = head;

        while (middle - 1 != 0) {
            cur = cur.next;
            middle--;
        }

        cur.next = cur.next.next;

        return head;

        /*
        if (head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return head;
         */
    }

    public static void main(String[] args) {
        DeleteMiddleNode solution = new DeleteMiddleNode();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode result = solution.deleteMiddle(head);
        while (result != null) {
            System.out.print(result.val + " ");// Output: 1 2 4
            result = result.next;
        }
    }
}

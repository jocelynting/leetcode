package linkedlist;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = dummy;
            dummy = cur;
            cur = next;
        }

        return dummy;
    }

    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();

        // Test case
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original Linked List: ");
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();

        ListNode reversedHead = solution.reverseList(head);

        System.out.print("Reversed Linked List: ");
        ListNode reversed = reversedHead;
        while (reversed != null) {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        }
        System.out.println();
    }
}

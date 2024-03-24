package linkedlist;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;

        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        DeleteDuplicates solution = new DeleteDuplicates();

        // Test Case 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);
        System.out.println("Test Case 1:");
        System.out.print("Original List: ");
        solution.printLinkedList(head1);
        ListNode result1 = solution.deleteDuplicates(head1);
        System.out.print("List after removing duplicates: ");
        solution.printLinkedList(result1);

        // Test Case 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(3);
        head2.next.next.next.next = new ListNode(3);
        System.out.println("\nTest Case 2:");
        System.out.print("Original List: ");
        solution.printLinkedList(head2);
        ListNode result2 = solution.deleteDuplicates(head2);
        System.out.print("List after removing duplicates: ");
        solution.printLinkedList(result2);
    }

    public void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}

package linkedlist;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode smallNode = new ListNode(0);
        ListNode small = smallNode;
        ListNode largeNode = new ListNode(0);
        ListNode large = largeNode;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }

        large.next = null;
        small.next = largeNode.next;

        return smallNode.next;
    }

    // Test the solution
    public static void main(String[] args) {
        PartitionList solution = new PartitionList();

        // Test Case 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(2);
        int x1 = 3;
        System.out.println("Test Case 1:");
        System.out.println("Original List:");
        solution.printList(head1);
        ListNode result1 = solution.partition(head1, x1);
        System.out.println("Partitioned List:");
        solution.printList(result1);
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

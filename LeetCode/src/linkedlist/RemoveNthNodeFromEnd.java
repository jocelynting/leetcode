package linkedlist;

public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0,head);

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

//    public ListNode removeNthFromEnd(ListNode head, int n) {
//
//        int count = 0;
//
//        ListNode dummy = new ListNode(0,head);
//        ListNode cur = dummy;
//
//        while (cur.next != null) {
//            cur = cur.next;
//            count++;
//        }
//
//        int num = count - n;
//        cur = dummy;
//        count = 0;
//
//        while (cur.next != null) {
//            if (count == num) {
//                cur.next = cur.next.next;
//                break;
//            }
//            cur = cur.next;
//            count++;
//        }
//
//        return dummy.next;
//    }

    public static void main(String[] args) {
        RemoveNthNodeFromEnd solution = new RemoveNthNodeFromEnd();

        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original list:");
        solution.printList(head); // Output: 1 2 3 4 5

        // Remove the 2nd node from the end (n = 2)
        ListNode newHead = solution.removeNthFromEnd(head, 2);

        System.out.println("List after removing the 2nd node from the end:");
        solution.printList(newHead); // Output: 1 2 3 5
    }

    public void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}

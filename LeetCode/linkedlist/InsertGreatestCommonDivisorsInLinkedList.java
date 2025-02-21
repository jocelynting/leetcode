package linkedlist;

public class InsertGreatestCommonDivisorsInLinkedList {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            int gcd = gcd(cur.val, cur.next.val);
            ListNode node = new ListNode(gcd);
            node.next = cur.next;
            cur.next = node;
            cur = cur.next.next;
        }

        return head;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        InsertGreatestCommonDivisorsInLinkedList solution = new InsertGreatestCommonDivisorsInLinkedList();
        ListNode head = new ListNode(18);
        head.next = new ListNode(24);
        head.next.next = new ListNode(30);

        ListNode result = solution.insertGreatestCommonDivisors(head);
        printList(result);  // Output: 18 -> 6 -> 24 -> 6 -> 30
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}

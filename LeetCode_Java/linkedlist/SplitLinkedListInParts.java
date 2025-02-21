package linkedlist;

public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }

        int split = length / k;
        int mod = length % k;
        ListNode[] result = new ListNode[k];
        cur = head;

        for (int i = 0; i < k && cur != null; i++) {
            result[i] = cur;
            int size = split + (i < mod ? 1 : 0);

            for (int j = 1; j < size; j++) {
                cur = cur.next;
            }

            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }

        return result;
    }

    public static void main(String[] args) {
        SplitLinkedListInParts solution = new SplitLinkedListInParts();

        // Test case 1: List [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next.next = new ListNode(7);
        root.next.next.next.next.next.next.next = new ListNode(8);
        root.next.next.next.next.next.next.next.next = new ListNode(9);
        root.next.next.next.next.next.next.next.next.next = new ListNode(10);

        ListNode[] result = solution.splitListToParts(root, 3);
        printParts(result);  // Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]

        // Test case 2: List [1, 2, 3], k = 5
        ListNode root2 = new ListNode(1);
        root2.next = new ListNode(2);
        root2.next.next = new ListNode(3);

        ListNode[] result2 = solution.splitListToParts(root2, 5);
        printParts(result2);  // Output: [[1], [2], [3], [], []]
    }

    private static void printParts(ListNode[] parts) {
        for (ListNode part : parts) {
            ListNode current = part;
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}

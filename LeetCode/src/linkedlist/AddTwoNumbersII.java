package linkedlist;

public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            cur.next = new ListNode(sum % 10);
            carry = sum / 10;
            cur = cur.next;
        }

        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        AddTwoNumbersII solution = new AddTwoNumbersII();

        ListNode l1 = createList(new int[]{7, 2, 4, 3});
        ListNode l2 = createList(new int[]{5, 6, 4});
        ListNode result1 = solution.addTwoNumbers(l1, l2);
        printList(result1); // Output: [7, 8, 0, 7]

        ListNode l3 = createList(new int[]{2, 4, 3});
        ListNode l4 = createList(new int[]{5, 6, 4});
        ListNode result2 = solution.addTwoNumbers(l3, l4);
        printList(result2); // Output: [8, 0, 7]

        ListNode l5 = createList(new int[]{0});
        ListNode l6 = createList(new int[]{0});
        ListNode result3 = solution.addTwoNumbers(l5, l6);
        printList(result3); // Output: [0]
    }

    public static void printList(ListNode node) {
        if (node == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
            if (node != null) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static ListNode createList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }
}

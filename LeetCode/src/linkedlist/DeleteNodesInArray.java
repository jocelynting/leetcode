package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class DeleteNodesInArray {
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        while (head != null) {
            if (!set.contains(head.val)) {
                cur.next = head;
                cur = cur.next;
            }
            head = head.next;
        }

        cur.next = null;

        return dummy.next;
    }

    public static void main(String[] args) {
        DeleteNodesInArray solution = new DeleteNodesInArray();

        int[] nums1 = {1, 2, 3};
        ListNode head1 = createLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode result1 = solution.modifiedList(nums1, head1);
        printLinkedList(result1); // Expected Output: [4, 5]

        int[] nums2 = {1};
        ListNode head2 = createLinkedList(new int[]{1, 2, 1, 2, 1, 2});
        ListNode result2 = solution.modifiedList(nums2, head2);
        printLinkedList(result2); // Expected Output: [2, 2, 2]
    }

    public static ListNode createLinkedList(int[] values) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    public static void printLinkedList(ListNode head) {
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

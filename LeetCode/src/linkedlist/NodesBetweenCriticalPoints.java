package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class NodesBetweenCriticalPoints {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode center = head.next;
        int index = 1;

        List<Integer> result = new ArrayList<>();

        while (center.next != null) {
            int prev = head.val;
            int cur = center.val;
            int next = center.next.val;

            if ((cur < prev && cur < next) || (cur > prev && cur > next)) {
                result.add(index);
            }
            head = head.next;
            center = center.next;
            index++;
        }

        if (result.size() < 2) {
            return new int[]{-1, -1};
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < result.size(); i++) {
            min = Math.min(min, result.get(i) - result.get(i - 1));
        }

        int max = result.get(result.size() - 1) - result.get(0);
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        NodesBetweenCriticalPoints solution = new NodesBetweenCriticalPoints();

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(3);
        head1.next.next.next.next.next = new ListNode(2);

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next = new ListNode(1);
        head2.next.next.next.next.next.next = new ListNode(2);

        int[] result1 = solution.nodesBetweenCriticalPoints(head1);
        int[] result2 = solution.nodesBetweenCriticalPoints(head2);

        System.out.println("Result 1: [" + result1[0] + ", " + result1[1] + "]");
        System.out.println("Result 2: [" + result2[0] + ", " + result2[1] + "]");
    }
}

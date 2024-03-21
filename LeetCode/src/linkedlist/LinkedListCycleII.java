package linkedlist;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        // Create a linked list with a cycle
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2; // Creates the cycle

        // Find the starting point of the cycle
        LinkedListCycleII solution = new LinkedListCycleII();
        ListNode cycleStart = solution.detectCycle(head);

        // Print the starting point of the cycle
        if (cycleStart != null) {
            System.out.println("Starting point of the cycle: " + cycleStart.val); // Output: 2
        } else {
            System.out.println("No cycle found.");
        }
    }
}

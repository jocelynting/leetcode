package linkedlist;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        // Create the first linked list: 4 -> 1 -> 8 -> 4 -> 5
        ListNode headA = new ListNode(4);
        ListNode node1 = new ListNode(1);
        ListNode node8 = new ListNode(8);
        ListNode node4_1 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        headA.next = node1;
        node1.next = node8;
        node8.next = node4_1;
        node4_1.next = node5;

        // Create the second linked list: 5 -> 0 -> 1 -> 8 -> 4 -> 5
        ListNode headB = new ListNode(5);
        ListNode node0 = new ListNode(0);
        headB.next = node0;
        node0.next = node1; // Intersection point
        // Alternatively, you could connect node8 to node0 to create the intersection.

        // Find the intersection node
        IntersectionOfTwoLinkedLists solution = new IntersectionOfTwoLinkedLists();
        ListNode intersectionNode = solution.getIntersectionNode(headA, headB);

        // Print the intersection node value (or null if no intersection)
        if (intersectionNode != null) {
            System.out.println("Intersection Node Value: " + intersectionNode.val); // Output: 1
        } else {
            System.out.println("No intersection found.");
        }
    }
}

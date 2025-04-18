from ListNode import ListNode
from typing import Optional


class LinkedListCycleII:
    def hasCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return None

        slow, fast = head, head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                break
        else:
            return None

        slow = head
        while slow != fast:
            slow = slow.next
            fast = fast.next

        return slow


# Time Complexity: O(n)
# Space Complexity: O(1)


if __name__ == "__main__":
    solution = LinkedListCycleII()

    node1 = ListNode(3)
    node2 = ListNode(2)
    node3 = ListNode(0)
    node4 = ListNode(-4)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node2

    print("Test Case 1: Input: [3, 2, 0, -4], pos = 1")
    print("Expected Output: 2")
    print(
        "Actual Output:",
        solution.hasCycle(node1).val if solution.hasCycle(node1) else None,
    )

    node1 = ListNode(1)
    node2 = ListNode(2)
    node1.next = node2
    node2.next = node1
    print("Test Case 2: Input: [1, 2], pos = 0")
    print("Expected Output: 1")
    print(
        "Actual Output:",
        solution.hasCycle(node1).val if solution.hasCycle(node1) else None,
    )

    node1 = ListNode(1)
    print("Test Case 3: Input: [1], pos = -1")
    print("Expected Output: None")
    print(
        "Actual Output:",
        solution.hasCycle(node1).val if solution.hasCycle(node1) else None,
    )

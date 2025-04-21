from typing import Optional
from ListNode import ListNode


class MiddleOfTheLinkedList:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow = head
        fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        return slow


# Time Complexity: O(n)
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = MiddleOfTheLinkedList()

    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)

    result = solution.middleNode(head)
    print("Expected Output: 3")
    print("Actual Output:", result.val)

    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)
    head.next.next.next.next.next = ListNode(6)

    result = solution.middleNode(head)
    print("Expected Output: 4")
    print("Actual Output:", result.val)

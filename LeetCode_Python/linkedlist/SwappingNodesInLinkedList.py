from typing import Optional
from ListNode import ListNode


class SwappingNodesInLinkedList:
    def swapNodes(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        begin = head

        for _ in range(1, k):
            begin = begin.next

        slow = head
        fast = begin

        while fast.next:
            slow = slow.next
            fast = fast.next

        end = slow
        begin.val, end.val = end.val, begin.val

        return head


# Time Complexity: O(n)
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = SwappingNodesInLinkedList()

    # Example 1
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)

    print("Expected Output: 1 -> 4 -> 3 -> 2 -> 5")
    print("Actual OUtput:", end="")
    result = solution.swapNodes(head, 2)
    while result:
        if result.next is None:
            print(result.val)
        else:
            print(result.val, end=" -> ")
        result = result.next

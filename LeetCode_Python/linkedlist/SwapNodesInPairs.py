from ListNode import ListNode
from typing import Optional


class SwapNodesInPairs:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head

        first = head
        second = head.next

        first.next = self.swapPairs(second.next)
        second.next = first

        return second

    def swapPairsIterative(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        prev = dummy

        while head and head.next:
            first = head
            second = head.next

            prev.next = second
            first.next = second.next
            second.next = first

            prev = first
            head = first.next

        return dummy.next


# Time Complexity: O(n)
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = SwapNodesInPairs()

    head1 = ListNode(1)
    head1.next = ListNode(2)
    head1.next.next = ListNode(3)
    head1.next.next.next = ListNode(4)

    print("Expected Output: 2 -> 1 -> 4 -> 3")
    result = solution.swapPairs(head1)
    print("Actual Output:", end="")
    while result:
        if result.next is None:
            print(result.val)
        else:
            print(result.val, end=" -> ")
        result = result.next

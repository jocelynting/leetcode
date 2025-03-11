from typing import Optional
from ListNode import ListNode


class PartitionList:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        if not head:
            return head

        before_head = before = ListNode(0)
        after_head = after = ListNode(0)

        while head:
            if head.val < x:
                before.next = head
                before = before.next
            else:
                after.next = head
                after = after.next
            head = head.next

        after.next = None
        before.next = after_head.next

        return before_head.next


if __name__ == "__main__":
    solution = PartitionList()

    node = ListNode(1)
    node.next = ListNode(4)
    node.next.next = ListNode(3)
    node.next.next.next = ListNode(2)
    node.next.next.next.next = ListNode(5)
    node.next.next.next.next.next = ListNode(2)

    print("Expected Output: 1 -> 2 -> 2 -> 4 -> 3 -> 5")
    print("Actual Output:")
    current = solution.partition(node, 3)
    while current:
        if current.next == None:
            print(current.val)
        else:
            print(current.val, end=" -> ")
        current = current.next

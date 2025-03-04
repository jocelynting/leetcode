from typing import Optional
from ListNode import ListNode


class ReverseLinkedList:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head

        pre = None
        while head:
            next_node = head.next
            head.next = pre
            pre = head
            head = next_node

        return pre


if __name__ == '__main__':
    solution = ReverseLinkedList()

    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)

    result = solution.reverseList(head)
    print("Expected Output:", "[5, 4, 3, 2, 1]")

    actual = []
    while result:
        actual.append(result.val)
        result = result.next
    print("Actual Output:", actual)

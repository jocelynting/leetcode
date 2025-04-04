from typing import Optional
from ListNode import ListNode


class RotateList:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or not head.next or k == 0:
            return head

        length = 1
        cur = head

        while cur.next:
            cur = cur.next
            length += 1

        cur.next = head

        steps = length - k % length
        tail = head

        for _ in range(1, steps):
            tail = tail.next

        new_head = tail.next
        tail.next = None

        return new_head


# Time Complexity: O(n)
# Space Complexity: O(1)


if __name__ == "__main__":
    solution = RotateList()

    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)

    print("Expected Output: 4 -> 5 -> 1 -> 2 -> 3")
    print("Actual Output:", end=" ")
    result = solution.rotateRight(head, 2)
    while result:
        if result.next:
            print(result.val, end=" -> ")
        else:
            print(result.val)
        result = result.next

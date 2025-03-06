from typing import Optional
from ListNode import ListNode


class AddTwoNumbers:
    def addTwoNumbers(
        self, l1: Optional[ListNode], l2: Optional[ListNode]
    ) -> Optional[ListNode]:
        carry = 0
        dummy = ListNode()
        cur = dummy

        while l1 or l2 or carry:
            total = carry
            if l1:
                total += l1.val
                l1 = l1.next
            if l2:
                total += l2.val
                l2 = l2.next

            cur.next = ListNode(total % 10)
            cur = cur.next
            carry = total // 10

        return dummy.next


if __name__ == "__main__":
    l1 = ListNode(2)
    l1.next = ListNode(4)
    l1.next.next = ListNode(3)

    l2 = ListNode(5)
    l2.next = ListNode(6)
    l2.next.next = ListNode(4)

    solution = AddTwoNumbers()
    result = solution.addTwoNumbers(l1, l2)
    print("Expected Output: [7, 0, 8]")

    res = []
    while result:
        res.append(result.val)
        result = result.next
    print("Actual Output:", res)

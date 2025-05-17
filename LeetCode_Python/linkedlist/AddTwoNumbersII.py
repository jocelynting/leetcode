from typing import Optional
from ListNode import ListNode


class AddTwoNumbersII:
    def addTwoNumbers(
        self, l1: Optional[ListNode], l2: Optional[ListNode]
    ) -> Optional[ListNode]:
        def reverse(head: Optional[ListNode]) -> Optional[ListNode]:
            prev = None
            while head:
                next_node = head.next
                head.next = prev
                prev = head
                head = next_node
            return prev

        l1 = reverse(l1)
        l2 = reverse(l2)

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

        return reverse(dummy.next)


# Time Complexity: O(max(m, n)), where m and n are the lengths of the two linked lists
# Space Complexity: O(max(m, n)), for the result linked list


if __name__ == "__main__":
    solution = AddTwoNumbersII()

    l1 = ListNode(7)
    l1.next = ListNode(2)
    l1.next.next = ListNode(4)
    l1.next.next.next = ListNode(3)

    l2 = ListNode(5)
    l2.next = ListNode(6)
    l2.next.next = ListNode(4)

    result = solution.addTwoNumbers(l1, l2)
    print("Expected Output:  7 -> 8 -> 0 -> 7")
    print("Actual Output:", end=" ")
    while result:
        if result.next:
            print(result.val, end=" -> ")
        else:
            print(result.val)
        result = result.next

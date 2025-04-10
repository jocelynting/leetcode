from typing import Optional
from ListNode import ListNode


class OddEvenLinkedList:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head

        odd = head
        even = head.next
        even_head = even

        while odd.next and even.next:
            odd.next = even.next
            odd = odd.next
            even.next = odd.next
            even = even.next

        odd.next = even_head

        return head


# Time Complexity: O(n)
# Space Complexity: O(1)

if __name__ == "__main__":
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)

    solution = OddEvenLinkedList()
    result = solution.oddEvenList(head)

    print("Expected Output: 1 -> 3 -> 5 -> 2 -> 4")
    print("Actual Output: ", end="")
    while result:
        if result.next:
            print(result.val, end=" -> ")
        else:
            print(result.val)
        result = result.next

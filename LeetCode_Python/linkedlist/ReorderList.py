from typing import Optional
from ListNode import ListNode


class ReorderList:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head or not head.next:
            return

        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        prev = None
        curr = slow
        while curr:
            next_node = curr.next
            curr.next = prev
            prev = curr
            curr = next_node

        first, second = head, prev
        while second.next:
            temp1, temp2 = first.next, second.next
            first.next, second.next = second, temp1
            first, second = temp1, temp2


# Time Complexity: O(n), where n is the number of nodes in the linked list.
# Space Complexity: O(1), no extra space is used.

if __name__ == "__main__":
    solution = ReorderList()

    root = ListNode(1)
    root.next = ListNode(2)
    root.next.next = ListNode(3)
    root.next.next.next = ListNode(4)

    print("Expected: 1 -> 4 -> 2 -> 3")
    solution.reorderList(root)
    print("Actual Output:", end=" ")
    while root:
        if root.next:
            print(root.val, end=" -> ")
        else:
            print(root.val)
        root = root.next

    root = ListNode(1)
    root.next = ListNode(2)
    root.next.next = ListNode(3)
    root.next.next.next = ListNode(4)
    root.next.next.next.next = ListNode(5)
    print("Expected Output: 1 -> 5 -> 2 -> 4 -> 3")
    solution.reorderList(root)
    print("Actual Output:", end=" ")
    while root:
        if root.next:
            print(root.val, end=" -> ")
        else:
            print(root.val)
        root = root.next

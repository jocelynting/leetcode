from ListNode import ListNode


class DeleteMiddleNode:
    def deleteMiddle(self, head: ListNode) -> ListNode:
        if not head.next:
            return None

        slow = head
        fast = head
        prev = None

        while fast and fast.next:
            prev = slow
            slow = slow.next
            fast = fast.next.next

        if prev:
            prev.next = slow.next

        return head


# Time Complexity: O(n), where n is the number of nodes in the linked list
# Space Complexity: O(1), we are using a constant amount of space for pointers

if __name__ == "__main__":
    solution = DeleteMiddleNode()

    head = ListNode(1)
    head.next = ListNode(3)
    head.next.next = ListNode(4)
    head.next.next.next = ListNode(7)
    head.next.next.next.next = ListNode(1)
    head.next.next.next.next.next = ListNode(2)
    head.next.next.next.next.next.next = ListNode(6)

    result = solution.deleteMiddle(head)
    print("Expected Output: 1 -> 3 -> 4 -> 1 -> 2 -> 6")
    print("Actual Output:", end=" ")
    while result:
        if result.next:
            print(result.val, end=" -> ")
        else:
            print(result.val)
        result = result.next

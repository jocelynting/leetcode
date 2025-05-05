from ListNode import ListNode


class MaximumTwinSum:
    def pairSum(self, head: ListNode) -> int:
        slow = fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        second = None
        while slow:
            next_node = slow.next
            slow.next = second
            second = slow
            slow = next_node

        res = 0
        first = head
        while second:
            res = max(res, first.val + second.val)
            first = first.next
            second = second.next

        return res


# Time Complexity: O(n), where n is the number of nodes in the linked list
# Space Complexity: O(1), we are using a constant amount of space for pointers

if __name__ == "__main__":
    solution = MaximumTwinSum()

    head = ListNode(5)
    head.next = ListNode(4)
    head.next.next = ListNode(2)
    head.next.next.next = ListNode(1)

    print("Expected Output: 6")
    print("Actual Output:", solution.pairSum(head))

    head = ListNode(4)
    head.next = ListNode(2)
    head.next.next = ListNode(2)
    head.next.next.next = ListNode(3)

    print("Expected Output: 7")
    print("Actual Output:", solution.pairSum(head))

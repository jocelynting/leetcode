from ListNode import ListNode


class DeleteNodeInLinkedList:
    def deleteNode(self, node):
        if node.next:
            node.val = node.next.val
            node.next = node.next.next
        else:
            node = None


# Time Complexity: O(1) since we are only modifying the current node and its next node
# Space Complexity: O(1) since we are not using any additional data structures

if __name__ == "__main__":
    solution = DeleteNodeInLinkedList()

    head = ListNode(4)
    head.next = ListNode(5)
    head.next.next = ListNode(1)
    head.next.next.next = ListNode(9)

    solution.deleteNode(head.next)

    print("Expected Output: 4 -> 1 -> 9")
    print("Actual Output: ", end="")
    current = head
    while current:
        if current.next is None:
            print(current.val, end="")
        else:
            print(current.val, end=" -> ")
        current = current.next

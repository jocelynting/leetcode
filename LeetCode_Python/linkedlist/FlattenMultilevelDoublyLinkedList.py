from typing import Optional


class Node:
    def __init__(self, val, prev, next, child):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child


class FlattenMultilevelDoublyLinkedList:
    def flatten(self, head: Optional[Node]) -> Optional[Node]:
        if not head:
            return head

        cur = head
        stack = []

        while cur:
            if cur.child:
                if cur.next:
                    stack.append(cur.next)
                    cur.next.prev = None
                cur.next = cur.child
                cur.child.prev = cur
                cur.child = None
            if not cur.next and stack:
                next_node = stack.pop()
                cur.next = next_node
                next_node.prev = cur
            cur = cur.next

        return head


# Time Complexity: O(n), where n is the number of nodes in the list. Each node is processed once.
# Space Complexity: O(n), for the stack used to keep track of the next nodes when traversing down the child pointers.

if __name__ == "__main__":
    solution = FlattenMultilevelDoublyLinkedList()

    node1 = Node(1, None, None, None)
    node2 = Node(2, None, None, None)
    node3 = Node(3, None, None, None)
    node4 = Node(4, None, None, None)
    node7 = Node(7, None, None, None)
    node8 = Node(8, None, None, None)
    node9 = Node(9, None, None, None)
    node11 = Node(11, None, None, None)
    node12 = Node(12, None, None, None)

    node1.next = node2
    node2.prev = node1
    node2.next = node3
    node3.prev = node2
    node3.next = node4
    node4.prev = node3

    node3.child = node7
    node7.next = node8
    node8.prev = node7
    node8.next = node9
    node9.prev = node8

    node8.child = node11
    node11.next = node12
    node12.prev = node11

    print("Expected Output: 1 -> 2 -> 3 -> 7 -> 8 -> 11 -> 12 -> 9 -> 4")
    result = solution.flatten(node1)
    print("Actual Output:", end=" ")
    while result:
        if result.next:
            print(result.val, end=" -> ")
        else:
            print(result.val)
        result = result.next

from typing import Optional


class Node:
    def __init__(self, x: int, next: "Node" = None, random: "Node" = None):
        self.val = int(x)
        self.next = next
        self.random = random


class CopyListWithRandomPointer:
    def copyRandomList(self, head: "Optional[Node]") -> "Optional[Node]":
        if not head:
            return None

        # Step 1: Create a new node for each node and insert it after the original node
        cur = head
        while cur:
            new_node = Node(cur.val)
            new_node.next = cur.next
            cur.next = new_node
            cur = new_node.next

        # Step 2: Assign random pointers for the new nodes
        cur = head
        while cur:
            cur.next.random = cur.random.next if cur.random else None
            cur = cur.next.next

        # Step 3: Separate the original and new nodes
        cur = head
        new_head = head.next
        new_cur = new_head
        while cur:
            cur.next = new_cur.next
            cur = cur.next
            new_cur.next = cur.next if cur else None
            new_cur = new_cur.next

        return new_head

    # Time Complexity: O(n)
    # Space Complexity: O(1)

    def copyRandomListByHashMap(self, head: "Optional[Node]") -> "Optional[Node]":
        if not head:
            return None

        node_map = {}
        cur = head
        while cur:
            node_map[cur] = Node(cur.val)
            cur = cur.next

        cur = head
        while cur:
            node_map[cur].next = node_map[cur.next] if cur.next else None
            node_map[cur].random = node_map[cur.random] if cur.random else None
            cur = cur.next

        return node_map[head]

    # Time Complexity: O(n)
    # Space Complexity: O(n)


if __name__ == "__main__":
    solution = CopyListWithRandomPointer()

    node1 = Node(1)
    node2 = Node(2)
    node3 = Node(3)
    node1.next = node2
    node2.next = node3
    node1.random = node3
    node2.random = node1
    node3.random = node2

    print("Expected Output: 1 3, 2 1, 3 2")
    new_head = solution.copyRandomList(node1)
    print("Actual Output:")
    while new_head:
        print(new_head.val, new_head.random.val if new_head.random else None)
        new_head = new_head.next

    print("Actual Output:")

    new_head = solution.copyRandomListByHashMap(node1)
    while new_head:
        print(new_head.val, new_head.random.val if new_head.random else None)
        new_head = new_head.next

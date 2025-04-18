from collections import deque


class Node:
    def __init__(
        self,
        val: int = 0,
        left: "Node" = None,
        right: "Node" = None,
        next: "Node" = None,
    ):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


class PopulatingNextRightPointersInEachNode:
    def connect(self, root: "Node") -> "Node":
        if not root:
            return None

        queue = deque([root])

        while queue:
            size = len(queue)
            prev = None

            for _ in range(size):
                node = queue.popleft()

                if prev:
                    prev.next = node
                prev = node

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

        return root


# Time Complexity: O(n), where n is the number of nodes in the tree.
# Space Complexity: O(n), for the queue that stores the nodes at the current level.

if __name__ == "__main__":
    solution = PopulatingNextRightPointersInEachNode()

    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    root.right.left = Node(6)
    root.right.right = Node(7)

    result = solution.connect(root)

    print("Expected Output:  1, None, 2, 3, None, 4, 5, 6, 7, None")
    print("Actual Output: ", end="")
    queue = deque([result])
    while queue:
        size = len(queue)
        for _ in range(size):
            node = queue.popleft()
            if node:
                print(node.val, end=", ")
                queue.append(node.left)
                queue.append(node.right)
        if queue:
            if queue[0]:
                print("None", end=", ")
            else:
                print("None")

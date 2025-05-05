from TreeNode import TreeNode
from typing import Optional
from collections import deque


class BinaryTreeRightSideView:
    def rightSideView(self, root: Optional[TreeNode]) -> list[int]:
        if not root:
            return []

        queue = deque([root])
        res = []

        while queue:
            size = len(queue)
            level = []

            for _ in range(size):
                node = queue.popleft()
                level.append(node.val)

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            res.append(level[-1])

        return res


# Time Complexity: O(n), where n is the number of nodes in the tree.
# Space Complexity: O(d), where d is the diameter of the tree, queue stores at most d nodes at any time.

if __name__ == "__main__":
    solution = BinaryTreeRightSideView()

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.right = TreeNode(5)
    root.right.right = TreeNode(4)

    print("Expected Output: [1, 3, 4]")
    print("Actual Output:", solution.rightSideView(root))

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.left.right = TreeNode(3)

    print("Expected Output: [1, 3]")
    print("Actual Output:", solution.rightSideView(root))

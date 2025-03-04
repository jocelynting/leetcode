from collections import deque
from typing import Optional
from TreeNode import TreeNode


class BinaryTreeLevelOrderTraversal:
    def levelOrder(self, root: Optional[TreeNode]) -> list[list[int]]:
        if not root:
            return []

        res = []
        queue = deque([root])

        while queue:
            size = len(queue)
            cur = []

            for i in range(size):
                node = queue.popleft()
                cur.append(node.val)

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            res.append(cur)

        return res


if __name__ == "__main__":
    solution = BinaryTreeLevelOrderTraversal()

    node = TreeNode(3)
    node.left = TreeNode(9)
    node.right = TreeNode(20)
    node.right.left = TreeNode(15)
    node.right.right = TreeNode(7)

    print("Excepted Output: [[3], [9, 20], [15, 7]]")
    print("Actual Output: ", solution.levelOrder(node))

from typing import Optional
from TreeNode import TreeNode
from collections import deque


class MaximumLevelSum:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        queue = deque([root])
        max_sum = float("-inf")
        level = 0
        res = 0

        while queue:
            size = len(queue)
            level += 1
            cur_sum = 0

            for _ in range(size):
                node = queue.popleft()
                cur_sum += node.val

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            if cur_sum > max_sum:
                max_sum = cur_sum
                res = level

        return res


# Time Complexity: O(n), where n is the number of nodes in the tree.
# Space Complexity: O(n), because in the worst case, we may have to store all nodes at the last level of the tree in the queue.

if __name__ == "__main__":
    solution = MaximumLevelSum()

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    root.right.right = TreeNode(6)

    print("Expected Output: 3")
    print("Actual Output:", solution.maxLevelSum(root))

    root = TreeNode(1)
    root.left = TreeNode(-5)
    root.right = TreeNode(-3)

    print("Expected Output: 1")
    print("Actual Output:", solution.maxLevelSum(root))

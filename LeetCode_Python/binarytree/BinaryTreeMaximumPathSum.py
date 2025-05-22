from typing import Optional
from TreeNode import TreeNode


class BinaryTreeMaximumPathSum:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.max_sum = float("-inf")

        def dfs(node: TreeNode) -> int:
            if not node:
                return 0

            left = max(0, dfs(node.left))
            right = max(0, dfs(node.right))

            self.max_sum = max(self.max_sum, left + right + node.val)

            return max(left, right) + node.val

        dfs(root)
        return self.max_sum


# Time Complexity: O(n), where n is the number of nodes in the tree.
# Space Complexity: O(h), where h is the height of the tree. This is due to the recursion stack.


if __name__ == "__main__":
    solution = BinaryTreeMaximumPathSum()

    root = TreeNode(-10)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right.left = TreeNode(15)
    root.right.right = TreeNode(7)
    print("Expected Output: 42")
    print("Actual Output:", solution.maxPathSum(root))

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    print("Expected Output: 6")
    print("Actual Output:", solution.maxPathSum(root))

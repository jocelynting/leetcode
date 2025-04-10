from TreeNode import TreeNode
from typing import Optional


class DiameterOfBinaryTree:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        def dfs(node: Optional[TreeNode]) -> int:
            if not node:
                return 0

            left = dfs(node.left)
            right = dfs(node.right)

            self.max_diameter = max(self.max_diameter, left + right)

            return max(left, right) + 1

        self.max_diameter = 0
        dfs(root)

        return self.max_diameter


# Time Complexity: O(n), where n is the number of nodes in the binary tree.
# Space Complexity: O(h), where h is the height of the binary tree. This is due to the recursion stack.

if __name__ == "__main__":
    solution = DiameterOfBinaryTree()

    # Example usage:
    # Constructing the binary tree:
    #       1
    #      / \
    #     2   3
    #    / \
    #   4   5
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)

    print("Expected Output: 3")
    print("Actual Output:", solution.diameterOfBinaryTree(root))

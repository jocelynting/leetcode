from typing import Optional
from TreeNode import TreeNode


class BalancedBinaryTree:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True

        def height(node: TreeNode) -> int:
            if not node:
                return 0
            left_height = height(node.left)
            right_height = height(node.right)
            if (
                left_height == -1
                or right_height == -1
                or abs(left_height - right_height) > 1
            ):
                return -1
            return max(left_height, right_height) + 1

        return height(root) != -1


# Time Complexity: O(n), where n is the number of nodes in the tree.
# Space Complexity: O(h), where h is the height of the tree, due to the recursion stack.

if __name__ == "__main__":
    solution = BalancedBinaryTree()

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    root.right.right = TreeNode(6)

    print("Expected Output: True")
    print("Actual Output:", solution.isBalanced(root))

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    root.right.right = TreeNode(6)
    root.left.left.left = TreeNode(7)
    root.left.left.right = TreeNode(8)
    root.left.left.left.left = TreeNode(9)
    root.left.left.left.right = TreeNode(10)
    print("Expected Output: False")
    print("Actual Output:", solution.isBalanced(root))

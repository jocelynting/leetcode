from typing import Optional
from TreeNode import TreeNode


class SumRootToLeafNumbers:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        def dfs(node: Optional[TreeNode], num) -> int:
            if not node:
                return 0

            num = num * 10 + node.val

            if not node.left and not node.right:
                return num

            return dfs(node.left, num) + dfs(node.right, num)

        return dfs(root, 0)


# Time Complexity: O(n), where n is the number of nodes in the tree.
# Space Complexity: O(h), where h is the height of the tree (due to recursion stack).

if __name__ == "__main__":
    solution = SumRootToLeafNumbers()

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    print("Expected Output: 25")
    print("Actual Output:", solution.sumNumbers(root))

    root = TreeNode(4)
    root.left = TreeNode(9)
    root.right = TreeNode(0)
    root.left.left = TreeNode(5)
    root.left.right = TreeNode(1)
    print("Expected Output: 1026")
    print("Actual Output:", solution.sumNumbers(root))

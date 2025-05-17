from typing import Optional
from TreeNode import TreeNode


class BinaryTreeInorderTraversal:
    def inorderTraversal(self, root: Optional[TreeNode]) -> list[int]:
        def dfs(node: Optional[TreeNode]) -> None:
            if not node:
                return

            dfs(node.left)
            res.append(node.val)
            dfs(node.right)

        res = []
        dfs(root)

        return res


# Time Complexity: O(n), where n is the number of nodes in the binary tree
# Space Complexity: O(h), where h is the height of the binary tree due to recursion stack space


if __name__ == "__main__":
    solution = BinaryTreeInorderTraversal()

    root1 = TreeNode(1)
    root1.right = TreeNode(2)
    root1.right.left = TreeNode(3)
    print("Expected Output: [1, 3, 2]")
    print("Actual Output:", solution.inorderTraversal(root1))

    root2 = TreeNode(1)
    print("Expected Output: [1]")
    print("Actual Output:", solution.inorderTraversal(root2))

from TreeNode import TreeNode
from typing import Optional


class PathSum:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:

        def dfs(node: TreeNode, target: int) -> bool:
            if not node:
                return False

            if not node.left and not node.right:
                return node.val == target

            return dfs(node.left, target - node.val) or dfs(
                node.right, target - node.val
            )

        return dfs(root, targetSum)


if __name__ == "__main__":
    solution = PathSum()

    root = TreeNode(5)
    root.left = TreeNode(4)
    root.right = TreeNode(8)
    root.left.left = TreeNode(11)
    root.left.left.left = TreeNode(7)
    root.left.left.right = TreeNode(2)
    root.right.left = TreeNode(13)
    root.right.right = TreeNode(4)
    root.right.right.right = TreeNode(1)

    print("Expected Output : True")
    print("Actual Output : ", solution.hasPathSum(root, 22))

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)

    print("Expected Output : False")
    print("Actual Output : ", solution.hasPathSum(root, 5))

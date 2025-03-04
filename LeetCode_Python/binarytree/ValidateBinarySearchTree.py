from TreeNode import TreeNode
from typing import Optional
import math


class ValidateBinarySearchTree:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        def dfs(node: Optional[TreeNode]) -> bool:
            if not node:
                return True
            if not dfs(node.left):
                return False
            if node.val <= self.pre:
                return False
            self.pre = node.val
            return dfs(node.right)

        self.pre = float('-inf')
        return dfs(root)

        # def dfs(node: Optional[TreeNode], min_val: int, max_val: int) -> bool:
        #     if not node:
        #         return True
        #     if not (min_val < node.val < max_val):
        #         return False
        #     return dfs(node.left, min_val, node.val) and dfs(node.right, node.val, max_val)

        # return dfs(root, -math.inf, math.inf)


if __name__ == "__main__":
    solution = ValidateBinarySearchTree()
    TreeNode1 = TreeNode(2)
    TreeNode1.left = TreeNode(1)
    TreeNode1.right = TreeNode(3)
    print("Expected Output:", True)
    print("Actual Output:", solution.isValidBST(TreeNode1))

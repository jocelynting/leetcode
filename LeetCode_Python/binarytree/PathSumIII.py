from typing import Optional
from TreeNode import TreeNode


class PathSumIII:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        prefix = {0: 1}

        def backtracking(node: TreeNode, total: int) -> int:
            if not node:
                return 0

            total += node.val
            count = prefix.get(total - targetSum, 0)
            prefix[total] = prefix.get(total, 0) + 1

            res = (
                count + backtracking(node.left, total) + backtracking(node.right, total)
            )

            prefix[total] -= 1

            return res

        return backtracking(root, 0)


if __name__ == "__main__":
    solution = PathSumIII()

    root = TreeNode(10)
    root.left = TreeNode(5)
    root.right = TreeNode(-3)
    root.left.left = TreeNode(3)
    root.left.right = TreeNode(2)
    root.right.right = TreeNode(11)
    root.left.left.left = TreeNode(3)
    root.left.left.right = TreeNode(-2)
    root.left.right.right = TreeNode(1)
    targetSum = 8
    print("Expected Output : 3")
    print("Actual Output : " + str(solution.pathSum(root, targetSum)))

from TreeNode import TreeNode
from typing import Optional
from collections import deque


class RangeSumOfBST:
    def rangeSumBST(self, root: Optional[TreeNode], low: int, high: int) -> int:
        res = 0
        queue = deque([root])

        while queue:
            node = queue.popleft()

            if low <= node.val <= high:
                res += node.val
            if node.left and node.val > low:
                queue.append(node.left)
            if node.right and node.val < high:
                queue.append(node.right)

        return res

    def rangeSumBSTRecursive(
        self, root: Optional[TreeNode], low: int, high: int
    ) -> int:
        self.res = 0

        def dfs(node: Optional[TreeNode]):
            if not node:
                return

            if low <= node.val <= high:
                self.res += node.val
            if node.val > low:
                dfs(node.left)
            if node.val < high:
                dfs(node.right)

        dfs(root)
        return self.res


# Time Complexity: O(n), where n is the number of nodes in the tree.
# Space Complexity: O(n) for the queue in the iterative solution, and O(h) for the recursive stack in the recursive solution.

if __name__ == "__main__":
    solution = RangeSumOfBST()

    root = TreeNode(10)
    root.left = TreeNode(5)
    root.right = TreeNode(15)
    root.left.left = TreeNode(3)
    root.left.right = TreeNode(7)
    root.right.right = TreeNode(18)
    low = 7
    high = 15
    print("Expected Output: 32")
    print("Actual Output:", solution.rangeSumBST(root, low, high))
    print("Actual Output:", solution.rangeSumBSTRecursive(root, low, high))

    low = 6
    high = 10
    print("Expected Output: 17")
    print("Actual Output:", solution.rangeSumBST(root, low, high))
    print("Actual Output:", solution.rangeSumBSTRecursive(root, low, high))

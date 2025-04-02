from TreeNode import TreeNode
from typing import Optional


class MaximumDepthOfBinaryTree:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        def dfs(node: TreeNode) -> int:
            if not node:
                return 0

            left_depth = dfs(node.left)
            right_depth = dfs(node.right)

            return max(left_depth, right_depth) + 1

        return dfs(root)

    def maxDepthByBFS(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        queue = [root]
        depth = 0

        while queue:
            depth += 1
            for _ in range(len(queue)):
                node = queue.pop(0)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

        return depth


# Time Complexity: O(n) where n is the number of nodes in the binary tree
# Space Complexity: O(h) where h is the height of the binary tree due to recursion stack space


if __name__ == "__main__":
    solution = MaximumDepthOfBinaryTree()

    root1 = TreeNode(3)
    root1.left = TreeNode(9)
    root1.right = TreeNode(20)
    root1.right.left = TreeNode(15)
    root1.right.right = TreeNode(7)
    print("Expected Output: 3")
    print("Actual Output: ", solution.maxDepth(root1))
    print("Actual Output: ", solution.maxDepthByBFS(root1))

    root2 = TreeNode(1)
    root2.left = TreeNode(2)
    print("Expected Output: 2")
    print("Actual Output: ", solution.maxDepth(root2))
    print("Actual Output: ", solution.maxDepthByBFS(root2))

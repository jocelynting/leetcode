from typing import Optional
from TreeNode import TreeNode
from collections import deque


class MinimumDepthOfBinaryTree:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        queue = deque([root])
        depth = 1

        while queue:
            for _ in range(len(queue)):
                node = queue.popleft()
                if not node.left and not node.right:
                    return depth
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            depth += 1

        return depth

    def minDepthByDFS(self, root: Optional[TreeNode]) -> int:
        def dfs(node: Optional[TreeNode]) -> int:
            if not node:
                return 0

            lh = dfs(node.left)
            rh = dfs(node.right)

            if not node.left:
                return rh + 1
            if not node.right:
                return lh + 1

            return min(lh, rh) + 1

        return dfs(root)


# Time Complexity: O(n) where n is the number of nodes in the binary tree
# Space Complexity: O(h) where h is the height of the binary tree due to recursion stack space

if __name__ == "__main__":
    solution = MinimumDepthOfBinaryTree()

    root1 = TreeNode(3)
    root1.left = TreeNode(9)
    root1.right = TreeNode(20)
    root1.right.left = TreeNode(15)
    root1.right.right = TreeNode(7)
    print("Expected Output: 2")
    print("Actual Output: ", solution.minDepth(root1))
    print("Actual Output: ", solution.minDepthByDFS(root1))

    root2 = TreeNode(2)
    root2.right = TreeNode(3)
    root2.right.right = TreeNode(4)
    root2.right.right.right = TreeNode(5)
    root2.right.right.right.right = TreeNode(6)
    print("Expected Output: 5")
    print("Actual Output: ", solution.minDepth(root2))
    print("Actual Output: ", solution.minDepthByDFS(root2))

from typing import Optional
from TreeNode import TreeNode
from collections import deque


class InvertBinaryTree:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:

        def dfs(node: Optional[TreeNode]) -> Optional[TreeNode]:
            if node is None:
                return None

            left = dfs(node.left)
            right = dfs(node.right)

            node.left = right
            node.right = left

            return node

        return dfs(root)

    def invertTreeByBFS(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root is None:
            return None

        queue = deque([root])

        while queue:
            node = queue.popleft()

            node.left, node.right = node.right, node.left

            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)

        return root


# Time Complexity: O(n), where n is the number of nodes in the tree.
# Space Complexity: O(h), where h is the height of the tree. This is due to the recursion stack in the DFS approach.
# For the BFS approach, the space complexity is O(w), where w is the maximum width of the tree.

if __name__ == "__main__":
    solution = InvertBinaryTree()

    root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(7)
    root.left.left = TreeNode(1)
    root.left.right = TreeNode(3)
    root.right.left = TreeNode(6)
    root.right.right = TreeNode(9)

    print("Expected Output: 4,7,2,9,6,3,1")
    print("Actual Output: ", end="")
    inverted_tree = solution.invertTree(root)

    def print_level_order(root):
        if not root:
            return
        queue = deque([root])
        while queue:
            node = queue.popleft()
            if node:
                print(node.val, end=",")
                queue.append(node.left)
                queue.append(node.right)

    print_level_order(inverted_tree)

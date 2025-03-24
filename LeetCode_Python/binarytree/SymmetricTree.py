from TreeNode import TreeNode
from typing import Optional
from collections import deque


class SymmetricTree:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def dfs(left: Optional[TreeNode], right: Optional[TreeNode]) -> bool:
            if not left and not right:
                return True
            if not left or not right:
                return False
            if left.val != right.val:
                return False
            return dfs(left.left, right.right) and dfs(left.right, right.left)

        return dfs(root.left, root.right) if root else True

    def isSymmetricByBFS(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True

        queue = deque([(root.left, root.right)])

        while queue:
            left, right = queue.popleft()

            if not left and not right:
                continue

            if not left or not right:
                return False

            if left.val != right.val:
                return False

            queue.append((left.left, right.right))
            queue.append((left.right, right.left))

        return True


# Time Complexity: O(n)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = SymmetricTree()

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(2)
    root.left.left = TreeNode(3)
    root.left.right = TreeNode(4)
    root.right.left = TreeNode(4)
    root.right.right = TreeNode(3)

    print("Expeted Output : True")
    print("Actual Output : ", solution.isSymmetric(root))
    print("Actual Output : ", solution.isSymmetricByBFS(root))

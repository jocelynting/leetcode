from collections import defaultdict, deque
from typing import Optional
from TreeNode import TreeNode


class BinaryTreeVerticalOrderTraversal:
    def verticalOrder(self, root: Optional[TreeNode]) -> list[list[int]]:
        if not root:
            return []

        cols = defaultdict(list)
        queue = deque([(root, 0)])
        minc = maxc = 0

        while queue:
            node, col = queue.popleft()
            cols[col].append(node.val)
            minc = min(minc, col)
            maxc = max(maxc, col)

            if node.left:
                queue.append((node.left, col - 1))
            if node.right:
                queue.append((node.right, col + 1))

        res = []
        for i in range(minc, maxc + 1):
            res.append(cols[i])

        return res


# Time Complexity: O(n), where n is the number of nodes in the binary tree.
# Space Complexity: O(n) for storing the nodes in the dictionary and the queue.

if __name__ == "__main__":
    solution = BinaryTreeVerticalOrderTraversal()

    root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right.left = TreeNode(15)
    root.right.right = TreeNode(7)
    print("Expected Output: [[9], [3, 15], [20], [7]]")
    print("Actual Output:", solution.verticalOrder(root))

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.right = TreeNode(4)
    root.right.right = TreeNode(5)
    print("Expected Output: [[2], [1, 4], [3], [5]]")
    print("Actual Output:", solution.verticalOrder(root))

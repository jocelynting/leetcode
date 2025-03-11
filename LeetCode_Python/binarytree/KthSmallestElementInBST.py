from typing import Optional
from TreeNode import TreeNode


class KthSmallestElementInBST:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.count = 0
        self.result = None

        def inorder(node: TreeNode) -> None:
            if not node:
                return

            inorder(node.left)
            self.count += 1
            if self.count == k:
                self.result = node.val
                return
            inorder(node.right)

        inorder(root)

        return self.result


if __name__ == "__main__":
    solution = KthSmallestElementInBST()

    root = TreeNode(3)
    root.left = TreeNode(1)
    root.right = TreeNode(4)
    root.left.right = TreeNode(2)
    print("Expected Output : 1")
    print("Actual Output : ", solution.kthSmallest(root, 1))

    root = TreeNode(5)
    root.left = TreeNode(3)
    root.right = TreeNode(6)
    root.left.left = TreeNode(2)
    root.left.right = TreeNode(4)
    root.left.left.left = TreeNode(1)
    print("Expected Output : 3")
    print("Actual Output : ", solution.kthSmallest(root, 3))

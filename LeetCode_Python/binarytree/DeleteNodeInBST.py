from typing import Optional
from TreeNode import TreeNode


class DeleteNodeInBST:
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        if not root:
            return None

        if root.val < key:
            root.left = self.deleteNode(root.left, key)
        elif root.val > key:
            root.right = self.deleteNode(root.right, key)
        else:
            if not root.left and not root.right:
                return None
            elif root.right:
                root.val = self.successor(root)
                root.right = self.deleteNode(root.right, root.val)
            else:
                root.val = self.predecessor(root)
                root.left = self.deleteNode(root.left, root.val)

        return root

    def successor(self, node: TreeNode) -> int:
        node = node.right
        while node.left:
            node = node.left
        return node.val

    def predecessor(self, node: TreeNode) -> int:
        node = node.left
        while node.right:
            node = node.right
        return node


# Time Complexity: O(logN) in the average case, O(N) in the worst case.
# Space Complexity: O(h), where h is the height of the tree. recursion stack.

if __name__ == "__main__":
    solution = DeleteNodeInBST()

    root = TreeNode(5)
    root.left = TreeNode(3)
    root.right = TreeNode(6)
    root.left.left = TreeNode(2)
    root.left.right = TreeNode(4)
    root.left.left.left = TreeNode(1)
    key = 3

    print("Expected output: 5")
    print(
        "Actual output:",
        (
            solution.deleteNode(root, key).val
            if solution.deleteNode(root, key)
            else "None"
        ),
    )

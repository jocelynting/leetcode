from typing import Optional
from TreeNode import TreeNode


class FlattenBinaryTreeToLinkedList:
    def flatten(self, root: Optional[TreeNode]) -> None:
        if not root:
            return

        self.flatten(root.left)
        self.flatten(root.right)

        if root.left:
            right = root.right
            root.right = root.left
            root.left = None

            cur = root.right
            while cur.right:
                cur = cur.right

            cur.right = right

    # Time Complexity: O(n), where n is the number of nodes in the tree.
    # Space Complexity: O(h), where h is the height of the tree due to recursion stack.

    def flatten_iterative(self, root: Optional[TreeNode]) -> None:
        if not root:
            return

        stack = [root]

        while stack:
            node = stack.pop()

            if node.right:
                stack.append(node.right)
            if node.left:
                stack.append(node.left)

            if stack:
                node.right = stack[-1]
            node.left = None

    # Time Complexity: O(n), where n is the number of nodes in the tree.
    # Space Complexity: O(n), where n is the number of nodes in the tree due to stack space.


if __name__ == "__main__":

    solution = FlattenBinaryTreeToLinkedList()

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(5)
    root.left.left = TreeNode(3)
    root.left.right = TreeNode(4)
    root.right.right = TreeNode(6)

    solution.flatten(root)

    print("Expected Output: 1 -> 2 -> 3 -> 4 -> 5 -> 6")
    print("Actual Output: ", end="")

    current = root
    while current:
        if current.right:
            print(current.val, end=" -> ")
        else:
            print(current.val)
        current = current.right

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(5)
    root.left.left = TreeNode(3)
    root.left.right = TreeNode(4)
    root.right.right = TreeNode(6)

    solution.flatten_iterative(root)

    print("Expected Output: 1 -> 2 -> 3 -> 4 -> 5 -> 6")
    print("Actual Output: ", end="")

    current = root
    while current:
        if current.right:
            print(current.val, end=" -> ")
        else:
            print(current.val)
        current = current.right

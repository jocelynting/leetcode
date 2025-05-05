from typing import Optional
from TreeNode import TreeNode


class SearchInBST:
    def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:

        def dfs(node: TreeNode) -> TreeNode:
            if not node:
                return None

            if node.val > val:
                return dfs(node.left)
            elif node.val < val:
                return dfs(node.right)
            else:
                return node

        return dfs(root)

    # Time Complexity: O(h), where h is the height of the tree.
    # That results in O(logN) in the average case, and O(N) in the worst case.
    # Space Complexity: O(h), where h is the height of the tree. recursion stack.
    # That results in O(logN) in the average case, and O(N) in the worst case.

    def searchBSTByIterative(
        self, root: Optional[TreeNode], val: int
    ) -> Optional[TreeNode]:
        while root:
            if root.val == val:
                return root
            elif root.val > val:
                root = root.left
            else:
                root = root.right
        return None

    # Time Complexity: O(h), where h is the height of the tree.
    # That results in O(logN) in the average case, and O(N) in the worst case.
    # Space Complexity: O(1), no extra space is used.


if __name__ == "__main__":
    solution = SearchInBST()

    root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(7)
    root.left.left = TreeNode(1)
    root.left.right = TreeNode(3)
    val = 2

    print("Expected output: 2")
    print(
        "Actual output:",
        solution.searchBST(root, val).val if solution.searchBST(root, val) else "None",
    )
    print(
        "Actual output:",
        (
            solution.searchBSTByIterative(root, val).val
            if solution.searchBSTByIterative(root, val)
            else "None"
        ),
    )

from TreeNode import TreeNode


class LowestCommonAncestorIV:
    def lowestCommonAncestor(self, root: TreeNode, nodes: list[TreeNode]) -> TreeNode:
        def dfs(node: TreeNode) -> TreeNode:
            if not node:
                return None
            if node in nodes:
                return node
            left = dfs(node.left)
            right = dfs(node.right)
            if left and right:
                return node
            return left if left else right

        return dfs(root)


# Time Complexity: O(n)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = LowestCommonAncestorIV()

    root = TreeNode(3)
    root.left = TreeNode(5)
    root.right = TreeNode(1)
    root.left.left = TreeNode(6)
    root.left.right = TreeNode(2)
    root.right.left = TreeNode(0)
    root.right.right = TreeNode(8)
    root.left.right.left = TreeNode(7)
    root.left.right.right = TreeNode(4)

    nodes = [root.left, root.right]
    print("Expected Output: 3")
    print("Actual Output:", solution.lowestCommonAncestor(root, nodes).val)

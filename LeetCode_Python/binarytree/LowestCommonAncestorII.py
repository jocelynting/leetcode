from TreeNode import TreeNode


class LowestCommonAncestorII:
    def lowestCommonAncestor(
        self, root: TreeNode, p: TreeNode, q: TreeNode
    ) -> TreeNode:
        self.count = 0

        def dfs(node: TreeNode) -> TreeNode:
            if not node:
                return None

            left = dfs(node.left)
            right = dfs(node.right)

            if node == p or node == q:
                self.count += 1
                return node

            if left and right:
                return node

            return left if left else right

        lca = dfs(root)
        return lca if self.count == 2 else None


# Time Complexity: O(n)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = LowestCommonAncestorII()

    root = TreeNode(3)
    root.left = TreeNode(5)
    root.right = TreeNode(1)
    root.left.left = TreeNode(6)
    root.left.right = TreeNode(2)
    root.right.left = TreeNode(0)
    root.right.right = TreeNode(8)
    root.left.right.left = TreeNode(7)
    root.left.right.right = TreeNode(4)

    p = root.left
    q = root.right

    print("Expected Output: 3")
    print("Actual Output:", solution.lowestCommonAncestor(root, p, q).val)

    p = root.left
    q = TreeNode(4)
    print("Expected Output: None")
    print("Actual Output:", solution.lowestCommonAncestor(root, p, q))

from TreeNode import TreeNode


class LowestCommonAncestor:
    def lowestCommonAncestor(
        self, root: "TreeNode", p: "TreeNode", q: "TreeNode"
    ) -> "TreeNode":

        def dfs(node: "TreeNode", p: "TreeNode", q: "TreeNode") -> "TreeNode":
            if not node:
                return None

            if node == p or node == q:
                return node

            left = dfs(node.left, p, q)
            right = dfs(node.right, p, q)

            if left and right:
                return node

            return left if left else right

        return dfs(root, p, q)


# Time Complexity: O(n)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = LowestCommonAncestor()

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
    q = root.left.right.right
    print("Expected Output: 5")
    print("Actual Output:", solution.lowestCommonAncestor(root, p, q).val)

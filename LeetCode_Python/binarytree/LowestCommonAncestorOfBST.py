from TreeNode import TreeNode


class LowestCommonAncestorOfBST:
    def lowestCommonAncestor(
        self, root: "TreeNode", p: "TreeNode", q: "TreeNode"
    ) -> "TreeNode":
        if p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        elif p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q)
        else:
            return root


# Time Complexity: O(n)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = LowestCommonAncestorOfBST()

    root = TreeNode(6)
    root.left = TreeNode(2)
    root.right = TreeNode(8)
    root.left.left = TreeNode(0)
    root.left.right = TreeNode(4)
    root.right.left = TreeNode(7)
    root.right.right = TreeNode(9)
    root.left.right.left = TreeNode(3)
    root.left.right.right = TreeNode(5)

    p = root.left
    q = root.right
    print("Expected Output : 6")
    print("Actual Output   :", solution.lowestCommonAncestor(root, p, q).val)

    p = root.left
    q = root.left.right
    print("Expected Output : 2")
    print("Actual Output   :", solution.lowestCommonAncestor(root, p, q).val)

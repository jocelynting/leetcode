from TreeNode import TreeNode


class LeafSimilarTrees:
    def leafSimilar(self, root1: TreeNode, root2: TreeNode) -> bool:
        def dfs(node, leaves):
            if not node:
                return
            if not node.left and not node.right:
                leaves.append(node.val)
            dfs(node.left, leaves)
            dfs(node.right, leaves)

        l1 = []
        l2 = []
        dfs(root1, l1)
        dfs(root2, l2)
        return l1 == l2


# Time Complexity: O(n), where n is the number of nodes in the tree
# Space Complexity: O(h), where h is the height of the tree (for the recursion stack)

if __name__ == "__main__":
    solution = LeafSimilarTrees()

    root1 = TreeNode(1)
    root1.left = TreeNode(2)
    root1.right = TreeNode(3)
    root1.left.left = TreeNode(4)
    root1.left.right = TreeNode(5)

    root2 = TreeNode(6)
    root2.left = TreeNode(7)
    root2.right = TreeNode(8)
    root2.left.left = TreeNode(9)
    root2.left.right = TreeNode(10)

    print("Expected Output: False")
    print("Actual Output:", solution.leafSimilar(root1, root2))

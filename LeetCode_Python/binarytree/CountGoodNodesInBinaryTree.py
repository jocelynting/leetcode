from TreeNode import TreeNode


class CountGoodNodesInBinaryTree:
    def goodNodes(self, root: TreeNode) -> int:

        def dfs(node: TreeNode, max_val: int) -> int:
            if not node:
                return 0

            good = 1 if node.val >= max_val else 0

            cur_max = max(node.val, max_val)
            left = dfs(node.left, cur_max)
            right = dfs(node.right, cur_max)

            return good + left + right

        return dfs(root, root.val)


# Time Complexity: O(n), where n is the number of nodes in the tree.
# Space Complexity: O(h), where h is the height of the tree due to recursion stack.

if __name__ == "__main__":
    solution = CountGoodNodesInBinaryTree()

    root = TreeNode(3)
    root.left = TreeNode(1)
    root.right = TreeNode(4)
    root.left.left = TreeNode(3)
    root.right.right = TreeNode(5)

    print("Expected Output: 4")
    print("Actual Output:", solution.goodNodes(root))

from TreeNode import TreeNode


class InsertIntoABST:
    def insertIntoBST(self, root: TreeNode, val: int):
        if not root:
            return TreeNode(val)
        if root.val < val:
            root.right = self.insertIntoBST(root.right, val)
        else:
            root.left = self.insertIntoBST(root.left, val)
        return root

    def inorderTraversal(self, node: TreeNode):
        res = []
        if node.left:
            res += self.inorderTraversal(node.left)
        res.append(node.val)
        if node.right:
            res += self.inorderTraversal(node.right)
        return res


# Time Complexity: O(log(n))
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = InsertIntoABST()

    root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(7)
    root.left.left = TreeNode(1)
    root.left.right = TreeNode(3)
    val = 5

    print("Expected Output: [1, 2, 3, 4, 5, 7]")
    print(
        "Actual Output:", solution.inorderTraversal(solution.insertIntoBST(root, val))
    )

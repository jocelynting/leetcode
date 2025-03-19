class Codec:
    def serialize(self, root):
        if not root:
            return "None"
        return (
            str(root.val)
            + ","
            + self.serialize(root.left)
            + ","
            + self.serialize(root.right)
        )

    def deserialize(self, data):
        def buildTree(vals):
            val = vals.pop(0)
            if val == "None":
                return None
            node = TreeNode(int(val))
            node.left = buildTree(vals)
            node.right = buildTree(vals)
            return node

        vals = data.split(",")
        return buildTree(vals)


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


if __name__ == "__main__":
    solution = Codec()
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.right.left = TreeNode(4)
    root.right.right = TreeNode(5)

    print("Expected Output : 1,2,None,None,3,4,None,None,5,None,None")
    print("Actual Output :", solution.serialize(root))

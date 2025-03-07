class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_file = False
        self.content = ""


class FileSystem:

    def __init__(self):
        self.root = TrieNode()

    def ls(self, path: str) -> list[str]:
        if path == "/":
            return sorted(self.root.children.keys())

        node = self.find(path)

        if node.is_file:
            return [path.split("/")[-1]]
        else:
            return sorted(node.children.keys())

    def mkdir(self, path: str) -> None:
        self.find(path)

    def addContentToFile(self, filePath: str, content: str) -> None:
        node = self.find(filePath, True)
        file_name = filePath.split("/")[-1]
        if file_name not in node.children:
            node.children[file_name] = TrieNode()
            node.children[file_name].is_file = True
        node.children[file_name].content += content

    def readContentFromFile(self, filePath: str) -> str:
        node = self.find(filePath)
        return node.content

    def find(self, path: str, file: bool = False) -> TrieNode:
        if file:
            parts = path.split("/")[1:-1]
        else:
            parts = path.split("/")[1:]
        node = self.root
        for part in parts:
            if part not in node.children:
                node.children[part] = TrieNode()
            node = node.children[part]
        return node


if __name__ == "__main__":
    solution = FileSystem()

    print("Expected Output : []")
    print("Actual Output : ", solution.ls("/"))
    solution.mkdir("/a/b/c")
    solution.addContentToFile("/a/b/c/d", "hello")
    print("Expected Output : ['a']")
    print("Actual Output : ", solution.ls("/"))
    print("Expected Output : ['b']")
    print("Actual Output : ", solution.ls("/a"))
    print("Expected Output : hello")
    print("Actual Output : ", solution.readContentFromFile("/a/b/c/d"))
    solution.addContentToFile("/a/b/c/d", "world")
    print("Expected Output : 'helloworld'")
    print("Actual Output : ", solution.readContentFromFile("/a/b/c/d"))

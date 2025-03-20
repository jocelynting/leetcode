class SimplifyPath:
    def simplifyPath(self, path: str) -> str:
        stack = []
        parts = path.split("/")

        for part in parts:
            if part == "" or part == ".":
                continue
            elif part == "..":
                if stack:
                    stack.pop()
            else:
                stack.append(part)

        res = "/" + "/".join(stack)
        return res


# Time Complexity: O(n)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = SimplifyPath()

    print("Expected Output: '/home'")
    print("Actual Output:", solution.simplifyPath("/home/"))

    print("Expected Output: '/'")
    print("Actual Output:", solution.simplifyPath("/../"))

    print("Expected Output: '/c'")
    print("Actual Output:", solution.simplifyPath("/a/./b/../../c/"))

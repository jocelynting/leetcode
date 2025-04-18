class RemoveAllAdjacentDuplicatesInString:
    def removeDuplicates(self, s: str) -> str:
        res = []
        for ch in s:
            if res and ch == res[-1]:
                res.pop()
            else:
                res.append(ch)
        return "".join(res)


# Time Complexity: O(n)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = RemoveAllAdjacentDuplicatesInString()

    print("Expected Output: ca")
    print("Actual Output:", solution.removeDuplicates("abbaca"))

    print("Expected Output: a")
    print("Actual Output:", solution.removeDuplicates("a"))

    print("Expected Output: ")
    print("Actual Output:", solution.removeDuplicates(""))

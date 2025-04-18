class RemoveAllAdjacentDuplicatesInStringII:
    def removeDuplicates(self, s: str, k: int) -> str:
        stack = []

        for char in s:
            if stack and stack[-1][0] == char:
                stack[-1][1] += 1

                if stack[-1][1] == k:
                    stack.pop()
            else:
                stack.append([char, 1])

        res = []

        for char, count in stack:
            res.append(char * count)

        return "".join(res)


# Time Complexity: O(n)
# Space Complexity: O(n)


if __name__ == "__main__":
    solution = RemoveAllAdjacentDuplicatesInStringII()

    print("Expected Output: abcd")
    print("Actual Output:", solution.removeDuplicates("abcd", 2))

    print("Expected Output: aa")
    print("Actual Output:", solution.removeDuplicates("deeedbbcccbdaa", 3))

    print("Expected Output: ps")
    print("Actual Output:", solution.removeDuplicates("pbbcggttciiippooaais", 2))

    print("Expected Output: ybth")
    print(
        "Actual Output:",
        solution.removeDuplicates("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4),
    )

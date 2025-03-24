class LongestCommonPrefix:
    def longestCommonPrefix(self, strs: list[str]) -> str:
        if not strs:
            return ""

        strs.sort()

        first, last = strs[0], strs[-1]
        n = min(len(first), len(last))

        i = 0
        while i < n and first[i] == last[i]:
            i += 1

        return first[:i]


# Time Complexity: O(nlogn)
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = LongestCommonPrefix()

    print("Expected Output: fl")
    print("Actual Output:", solution.longestCommonPrefix(["flower", "flow", "flight"]))

    print("Expected Output: ")
    print("Actual Output:", solution.longestCommonPrefix(["dog", "racecar", "car"]))

    print("Expected Output: ")
    print("Actual Output:", solution.longestCommonPrefix([]))

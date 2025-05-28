class MaximumLengthOfPairChain:
    def findLongestChain(self, pairs: list[list[int]]) -> int:
        pairs.sort(key=lambda x: x[1])
        cur = float("-inf")
        res = 0

        for a, b in pairs:
            if a > cur:
                res += 1
                cur = b

        return res


# Time Complexity: O(n log n), where n is the number of pairs due to sorting
# Space Complexity: O(1), as we are using a constant amount of space for variables

if __name__ == "__main__":
    solution = MaximumLengthOfPairChain()

    print("Expected Output : 2")
    print("Actual Output : ", solution.findLongestChain([[1, 2], [2, 3], [3, 4]]))

    print("Expected Output : 3")
    print("Actual Output : ", solution.findLongestChain([[1, 2], [7, 8], [4, 5]]))

    print("Expected Output : 3")
    print(
        "Actual Output : ", solution.findLongestChain([[1, 2], [2, 3], [3, 4], [5, 6]])
    )

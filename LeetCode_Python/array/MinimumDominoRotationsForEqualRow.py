class MinimumDominoRotationsForEqualRow:
    def minDominoRotations(self, tops: list[int], bottoms: list[int]) -> int:
        def check(x):
            t = b = 0
            for i in range(len(tops)):
                if tops[i] != x and bottoms[i] != x:
                    return float("inf")
                if tops[i] != x:
                    t += 1
                if bottoms[i] != x:
                    b += 1
            return min(t, b)

        res = min(check(tops[0]), check(bottoms[0]))
        return res if res != float("inf") else -1


# Time Complexity: O(n), where n is the length of the input lists
# Space Complexity: O(1)

if __name__ == "__main__":
    solution = MinimumDominoRotationsForEqualRow()

    print("Expected Output: 2")
    print(
        "Actual Output:",
        solution.minDominoRotations([2, 1, 2, 4, 2, 2], [5, 2, 6, 2, 3, 2]),
    )

    print("Expected Output: -1")
    print(
        "Actual Output:", solution.minDominoRotations([3, 5, 1, 2, 3], [4, 2, 4, 4, 4])
    )

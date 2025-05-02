class FindTheHighestAltitude:
    def largestAltitude(self, gain: list[int]) -> int:
        cur = res = 0

        for g in gain:
            cur += g
            res = max(res, cur)

        return res


# Time Complexity: O(n), where n is the length of the input list gain.
# Space Complexity: O(1), since we are using a constant amount of space.

if __name__ == "__main__":
    solution = FindTheHighestAltitude()

    print("Expected Output: 1")
    print("Actual Output:", solution.largestAltitude([-5, 1, 5, 0, -7]))

    print("Expected Output: 0")
    print("Actual Output:", solution.largestAltitude([-4, -3, -2, -1, 4, 3, 2]))

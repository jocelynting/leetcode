class CountOfMatchesInTournament:
    def numberOfMatches(self, n: int) -> int:
        res = 0
        while n > 1:
            res += n // 2
            n -= n // 2

        return res


# Time Complexity: O(log n), where n is the number of teams. The number of iterations is logarithmic in relation to n.
# Space Complexity: O(1), as we are using a constant amount of space for variables.

if __name__ == "__main__":
    solution = CountOfMatchesInTournament()

    print("Expected Output: 6")
    print("Actual Output:", solution.numberOfMatches(7))

    print("Expected Output: 13")
    print("Actual Output:", solution.numberOfMatches(14))

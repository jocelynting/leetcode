class Leaderboard:
    def __init__(self):
        self.leaderboard = {}

    # Space Complexity: O(n)

    def addScore(self, playerId: int, score: int) -> None:
        if playerId not in self.leaderboard:
            self.leaderboard[playerId] = score
        else:
            self.leaderboard[playerId] += score

    # Time Complexity: O(1)

    def top(self, K: int) -> int:
        top_scores = sorted(self.leaderboard.values(), reverse=True)
        return sum(top_scores[:K])

    # Time Complexity: O(nlogn)

    def reset(self, playerId: int) -> None:
        self.leaderboard[playerId] = 0

    # Time Complexity: O(1)


if __name__ == "__main__":
    solution = Leaderboard()

    solution.addScore(1, 73)
    solution.addScore(2, 56)
    solution.addScore(3, 39)
    solution.addScore(4, 51)
    solution.addScore(5, 4)

    print("Expected Output: 73")
    print("Actual Output:", solution.top(1))

    print("Expected Output: None")
    print("Actual Output:", solution.reset(1))

    print("Expected Output: None")
    print("Actual Output:", solution.reset(2))

    print("Expected Output: None")
    print("Actual Output:", solution.addScore(2, 51))

    print("Expected Output: 141")
    print("Actual Output:", solution.top(3))

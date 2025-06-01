class SolvingQuestionsWithBrainpower:
    def mostPoints(self, questions: list[list[int]]) -> int:
        n = len(questions)
        dp = [0] * n
        dp[-1] = questions[-1][0]

        for i in range(n - 2, -1, -1):
            points = questions[i][0]
            skip = questions[i][1]

            next_index = i + skip + 1
            if next_index < n:
                points += dp[next_index]

            dp[i] = max(points, dp[i + 1])

        return dp[0]


# Time Complexity: O(n), where n is the number of questions
# Space Complexity: O(n), for the dp array

if __name__ == "__main__":
    solution = SolvingQuestionsWithBrainpower()

    questions1 = [[3, 2], [4, 3], [4, 4], [2, 5]]
    print("Expected Output: 5")
    print("Actual Output:", solution.mostPoints(questions1))

    questions2 = [[1, 1], [2, 2], [3, 3]]
    print("Expected Output: 4")
    print("Actual Output:", solution.mostPoints(questions2))

    questions3 = [[10, 1], [9, 2], [8, 3], [7, 4]]
    print("Expected Output: 18")
    print("Actual Output:", solution.mostPoints(questions3))

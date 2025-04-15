class FindTheCelebrity:
    def findCelebrity(self, n: int) -> int:

        candidate = 0
        for i in range(1, n):
            if knows(candidate, i):
                candidate = i

        for i in range(n):
            if i != candidate and (knows(candidate, i) or not knows(i, candidate)):
                return -1

        return candidate


# Time Complexity: O(n)
# Space Complexity: O(1)

celebrity_matrix = []


def knows(a: int, b: int) -> bool:
    return celebrity_matrix[a][b]


if __name__ == "__main__":
    solution = FindTheCelebrity()
    n = 3
    celebrity_matrix = [
        [True, True, False],
        [False, True, False],
        [True, True, True],
    ]

    print("Expected Output: 1")
    print("Actual Output:", solution.findCelebrity(n))

    n = 3
    celebrity_matrix = [
        [True, False, True],
        [True, True, False],
        [False, True, True],
    ]
    print("Expected Output: -1")
    print("Actual Output:", solution.findCelebrity(n))

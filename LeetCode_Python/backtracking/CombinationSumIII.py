class CombinationSumIII:
    def combinationSum3(self, k: int, n: int) -> list[list[int]]:
        res = []

        def backtracking(index: int, total: int, cur: list[int]) -> None:
            if len(cur) == k:
                if total == n:
                    res.append(cur[:])
                return

            for i in range(index, 10):
                cur.append(i)
                backtracking(i + 1, total + i, cur)
                cur.pop()

        backtracking(1, 0, [])

        return res


# Time Complexity: O(C(9, k) * k), where C(9, k) is the number of combinations of 9 digits taken k at a time
# Space Complexity: O(k), for the recursion stack and the current combination

if __name__ == "__main__":
    solution = CombinationSumIII()

    print("Expected Output: [[1, 2, 4]]")
    print("Actual Output:", solution.combinationSum3(3, 7))

    print("Expected Output: [[1, 2, 6], [1, 3, 5], [2, 3, 4]]")
    print("Actual Output:", solution.combinationSum3(3, 9))

    print("Expected Output: []")
    print("Actual Output:", solution.combinationSum3(4, 1))

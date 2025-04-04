class PascalsTriangle:
    def generate(self, numRows: int) -> list[list[int]]:
        res = [[1]]

        for i in range(1, numRows):
            prev_row = res[-1]
            cur = [1]

            for j in range(1, i):
                cur.append(prev_row[j - 1] + prev_row[j])

            cur.append(1)
            res.append(cur)

        return res


# Time Complexity: O(n^2)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = PascalsTriangle()

    print("Expected Output: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]")
    print("Actual Output:", solution.generate(5))

    print("Expected Output: [[1]]")
    print("Actual Output:", solution.generate(1))

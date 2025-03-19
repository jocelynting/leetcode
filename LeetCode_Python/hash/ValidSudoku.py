class ValidSudoku:
    def isValidSudoku(self, board: list[list[str]]) -> bool:
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boxes = [set() for _ in range(9)]

        for i in range(9):
            for j in range(9):
                num = board[i][j]
                if num == ".":
                    continue
                box_index = (i // 3) * 3 + j // 3
                if num in rows[i] or num in cols[j] or num in boxes[box_index]:
                    return False
                rows[i].add(num)
                cols[j].add(num)
                boxes[box_index].add(num)

        return True


# Time: O(1)
# Space: O(1)
# 时间复杂度为 O(81)（即 O(1)），空间复杂度也是 O(1)（每个集合最多 9 个元素）。

if __name__ == "__main__":
    solution = ValidSudoku()

    board = [
        ["5", "3", ".", ".", "7", ".", ".", ".", "."],
        ["6", ".", ".", "1", "9", "5", ".", ".", "."],
        [".", "9", "8", ".", ".", ".", ".", "6", "."],
        ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
        ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
        ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
        [".", "6", ".", ".", ".", ".", "2", "8", "."],
        [".", ".", ".", "4", "1", "9", ".", ".", "5"],
        [".", ".", ".", ".", "8", ".", ".", "7", "9"],
    ]
    print("Expected Output: True")
    print("Actual Output:", solution.isValidSudoku(board))

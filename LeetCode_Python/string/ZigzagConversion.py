class ZigzagConversion:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1 or numRows >= len(s):
            return s

        rows = [""] * numRows
        cur = 0
        down = False

        for char in s:
            rows[cur] += char

            if cur == 0 or cur == numRows - 1:
                down = not down

            if down:
                cur += 1
            else:
                cur -= 1

        return "".join(rows)


# Time Complexity: O(n), where n is the length of the input string s.
# Space Complexity: O(n), as we are using a list of size n to store the rows.

if __name__ == "__main__":
    solution = ZigzagConversion()

    print("Expected Output: PAHNAPLSIIGYIR")
    print("Actual Output:", solution.convert("PAYPALISHIRING", 3))

    print("Expected Output: PINALSIGYAHRPI")
    print("Actual Output:", solution.convert("PAYPALISHIRING", 4))

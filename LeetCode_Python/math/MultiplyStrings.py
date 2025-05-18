class MultiplyStrings:
    def multiply(self, num1: str, num2: str) -> str:
        if num1 == "0" or num2 == "0":
            return "0"

        m, n = len(num1), len(num2)
        res = [0] * (m + n)

        for i in range(m - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                mul = int(num1[i]) * int(num2[j])
                carry, cur = i + j, i + j + 1

                total = mul + res[cur]
                res[cur] = total % 10
                res[carry] += total // 10

        s = "".join(map(str, res)).lstrip("0")

        return s


# Time Complexity: O(m * n), where m and n are the lengths of num1 and num2 respectively.
# Space Complexity: O(m + n), for the result array.

if __name__ == "__main__":
    solution = MultiplyStrings()

    print("Expected Output: 6")
    print("Actual Output:", solution.multiply("2", "3"))

    print("Expected Output: 56088")
    print("Actual Output:", solution.multiply("123", "456"))

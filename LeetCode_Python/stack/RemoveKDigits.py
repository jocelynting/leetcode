class RemoveKDigits:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []

        for n in num:
            while k > 0 and stack and stack[-1] > n:
                stack.pop()
                k -= 1
            stack.append(n)

        while k > 0:
            stack.pop()
            k -= 1

        res = "".join(stack).lstrip("0")

        return res if res else "0"


# Time Complexity: O(n), where n is the length of the input string num
# Space Complexity: O(n), for the stack used to store the digits

if __name__ == "__main__":
    solution = RemoveKDigits()

    num = "1432219"
    k = 3
    print("Expected Output: 1219")
    print("Actual Output:", solution.removeKdigits(num, k))

    num = "10200"
    k = 1
    print("Expected Output: 200")
    print("Actual Output:", solution.removeKdigits(num, k))

    num = "10"
    k = 2
    print("Expected Output: 0")
    print("Actual Output:", solution.removeKdigits(num, k))

class SumOfSubarrayMinimums:
    def sumSubarrayMins(self, arr: list[int]) -> int:
        n = len(arr)
        stack = []
        left = [0] * n

        for i in range(n):
            while stack and arr[stack[-1]] > arr[i]:
                stack.pop()
            left[i] = i + 1 if not stack else i - stack[-1]
            stack.append(i)

        stack = []
        right = [0] * n
        for i in range(n - 1, -1, -1):
            while stack and arr[stack[-1]] >= arr[i]:
                stack.pop()
            right[i] = n - i if not stack else stack[-1] - i
            stack.append(i)

        res = 0
        mod = 10**9 + 7

        for i in range(n):
            res = res + (arr[i] * left[i] * right[i]) % mod

        return res


# Time Complexity: O(n)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = SumOfSubarrayMinimums()

    arr = [3, 1, 2, 4]
    print("Expected Output: 17")
    print("Actual Output: ", solution.sumSubarrayMins(arr))

    arr = [11, 81, 94, 43, 3]
    print("Expected Output: 444")
    print("Actual Output: ", solution.sumSubarrayMins(arr))

    arr = [1, 2, 3, 4, 5]
    print("Expected Output: 35")
    print("Actual Output: ", solution.sumSubarrayMins(arr))

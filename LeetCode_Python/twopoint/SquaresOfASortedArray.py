class SquaresOfASortedArray:
    def sortedSquares(self, nums: list[int]) -> list[int]:
        n = len(nums)
        res = [0] * n
        left, right = 0, n - 1
        index = n - 1

        while left <= right:
            l = nums[left] ** 2
            r = nums[right] ** 2
            if l > r:
                res[index] = l
                left += 1
            else:
                res[index] = r
                right -= 1
            index -= 1

        return res


if __name__ == "__main__":
    solution = SquaresOfASortedArray()

    print("Expected Output: [0,1,9,16,100]")
    print("Actual  Output: ", solution.sortedSquares([-4, -1, 0, 3, 10]))

    print("Expected Output: [4,9,9,49,121]")
    print("Actual  Output: ", solution.sortedSquares([-7, -3, 2, 3, 11]))

class RotateArray:
    def rotate(self, nums: list[int], k: int) -> None:
        n = len(nums)
        k %= n

        def reverse(left: int, right: int) -> None:
            while left < right:
                nums[left], nums[right] = nums[right], nums[left]
                left += 1
                right -= 1

        reverse(0, n - 1)
        reverse(0, k - 1)
        reverse(k, n - 1)


if __name__ == "__main__":
    solution = RotateArray()

    nums = [1, 2, 3, 4, 5, 6, 7]
    solution.rotate(nums, 3)
    print("Expected Output: [5,6,7,1,2,3,4]")
    print("Actual Output:", nums)

    nums = [-1, -100, 3, 99]
    solution.rotate(nums, 2)
    print("Expected Output: [3,99,-1,-100]")
    print("Actual Output:", nums)

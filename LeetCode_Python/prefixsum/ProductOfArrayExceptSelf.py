class ProductOfArrayExceptSelf:
    def productExceptSelf(self, nums: list[int]) -> list[int]:
        n = len(nums)
        product = 1
        res = [1] * n

        for i in range(n):
            res[i] = product
            product *= nums[i]

        product = 1

        for i in range(n - 1, -1, -1):
            res[i] = product * res[i]
            product *= nums[i]

        return res


if __name__ == "__main__":
    solution = ProductOfArrayExceptSelf()

    print("Expected Output: [24,12,8,6]")
    print("Actual Output:", solution.productExceptSelf([1, 2, 3, 4]))

    print("Expected Output: [0,0,9,0,0]")
    print("Actual Output:", solution.productExceptSelf([-1, 1, 0, -3, 3]))

    print("Expected Output: [0,0,0,0]")
    print("Actual Output:", solution.productExceptSelf([0, 0, 0, 0]))

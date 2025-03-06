class ContainerWithMostWater:
    def maxArea(self, height: list[int]) -> int:
        res = 0

        left, right = 0, len(height) - 1

        while left < right:
            lh, rh = height[left], height[right]
            res = max(res, min(lh, rh) * (right - left))
            if lh < rh:
                left += 1
            else:
                right -= 1

        return res


if __name__ == "__main__":
    solution = ContainerWithMostWater()

    height1 = [1, 8, 6, 2, 5, 4, 8, 3, 7]
    print("Expected Output: 49")
    print("Actual Output:", solution.maxArea(height1))

    height2 = [1, 1]
    print("Expected Output: 1")
    print("Actual Output:", solution.maxArea(height2))

    height3 = [4, 3, 2, 1, 4]
    print("Expected Output: 16")
    print("Actual Output:", solution.maxArea(height3))

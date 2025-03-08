class TrappingRainWater:
    def trap(self, height: list[int]) -> int:
        left, right = 0, len(height) - 1
        left_max, right_max = 0, 0
        res = 0

        while left < right:
            if height[left] < height[right]:
                if height[left] >= left_max:
                    left_max = height[left]
                else:
                    res += left_max - height[left]
                left += 1
            else:
                if height[right] >= right_max:
                    right_max = height[right]
                else:
                    res += right_max - height[right]
                right -= 1

        return res


if __name__ == "__main__":
    solution = TrappingRainWater()

    height1 = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    print("Expected Output : 6")
    print("Actual Output :", solution.trap(height1))

    height2 = [4, 2, 0, 3, 2, 5]
    print("Expected Output : 9")
    print("Actual Output :", solution.trap(height2))

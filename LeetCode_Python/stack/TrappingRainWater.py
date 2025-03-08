class TrappingRainWater:
    def trap(self, height: list[int]) -> int:
        stack = []
        res = 0

        for i in range(len(height)):
            while stack and height[i] > height[stack[-1]]:
                top = stack.pop()
                if not stack:
                    break
                w = i - stack[-1] - 1
                h = min(height[i], height[stack[-1]]) - height[top]
                res += w * h
            stack.append(i)

        return res


if __name__ == "__main__":
    solution = TrappingRainWater()

    height1 = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    print("Expected Output : 6")
    print("Actual Output :", solution.trap(height1))

    height2 = [4, 2, 0, 3, 2, 5]
    print("Expected Output : 9")
    print("Actual Output :", solution.trap(height2))

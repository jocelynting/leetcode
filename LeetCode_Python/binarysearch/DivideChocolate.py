class DivideChocolate:
    def maximizeSweetness(self, sweetness: list[int], k: int) -> int:
        def calculate(target: int) -> int:
            total, count = 0, 0

            for s in sweetness:
                total += s
                if total >= target:
                    count += 1
                    total = 0

            return count

        left, right = min(sweetness), sum(sweetness) // (k + 1)

        while left <= right:
            mid = left + (right - left) // 2
            if calculate(mid) >= k + 1:
                left = mid + 1
            else:
                right = mid - 1

        return right


# Time Complexity: O(n log m), where n is the length of sweetness and m is the sum of sweetness.
# Space Complexity: O(1), as we are using a constant amount of space.

if __name__ == "__main__":
    solution = DivideChocolate()

    print("Expected Output: 9")
    print("Actual Output:", solution.maximizeSweetness([5, 6, 7, 8, 9], 2))

    print("Expected Output: 6")
    print("Actual Output:", solution.maximizeSweetness([1, 2, 3, 4, 5], 1))

    print("Expected Output: 1")
    print("Actual Output:", solution.maximizeSweetness([1, 2, 3, 4, 5], 4))

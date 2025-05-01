from collections import Counter


class MaxNumberOfKSumPairs:
    def maxOperations(self, nums: list[int], k: int) -> int:
        if len(nums) < 2:
            return 0

        counter = Counter(nums)
        res = 0

        for num in counter:
            target = k - num
            if target in counter:
                pairs = 0
                if num == target:
                    pairs = counter[num] // 2
                else:
                    pairs = min(counter[num], counter[target])

                res += pairs
                counter[num] -= pairs
                counter[target] -= pairs

        return res


# Time Complexity: O(n), where n is the length of the input list
# Space Complexity: O(n), since we are using a Counter to store the frequency of each number


if __name__ == "__main__":
    solution = MaxNumberOfKSumPairs()

    print("Expected Output: 2")
    print("Actual Output:", solution.maxOperations([1, 2, 3, 4], 5))

    print("Expected Output: 1")
    print("Actual Output:", solution.maxOperations([3, 1, 3, 4, 3], 6))

    print("Expected Output: 1")
    print("Actual Output:", solution.maxOperations([1, 2, 3, 4], 7))

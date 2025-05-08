import heapq


class MaximumSubsequenceScore:
    def maxScore(self, nums1: list[int], nums2: list[int], k: int) -> int:
        pairs = sorted(zip(nums2, nums1), key=lambda x: -x[0])
        heap = []
        total = 0
        res = 0

        for n2, n1 in pairs:
            heapq.heappush(heap, n1)
            total += n1

            if len(heap) > k:
                total -= heapq.heappop(heap)

            if len(heap) == k:
                res = max(res, total * n2)

        return res


# Time Complexity: O(n log n), heap operations take O(log n) time and we do this for n elements
# Space Complexity: O(n), we store n elements in the heap

if __name__ == "__main__":
    solution = MaximumSubsequenceScore()

    print("Expected Output: 12")
    print("Actual Output:", solution.maxScore([1, 3, 3, 2], [2, 1, 3, 4], 3))

    print("Expected Output: 30")
    print("Actual Output:", solution.maxScore([4, 2, 3, 1, 1], [7, 5, 10, 9, 6], 1))

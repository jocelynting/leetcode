import heapq


class KthLargestElement:
    def findKthLargest(self, nums: list[int], k: int) -> int:
        heap = []

        for n in nums:
            heapq.heappush(heap, n)
            if len(heap) > k:
                heapq.heappop(heap)

        return heap[0]


if __name__ == "__main__":

    solution = KthLargestElement()

    nums1 = [3, 2, 1, 5, 6, 4]
    k1 = 2
    print("Expected Output: 5")
    print("Actual Output:", solution.findKthLargest(nums1, k1))

    nums2 = [3, 2, 3, 1, 2, 4, 5, 5, 6]
    k2 = 4
    print("Expected Output: 4")
    print("Actual Output:", solution.findKthLargest(nums2, k2))

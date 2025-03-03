from collections import Counter
import heapq


class TopKFrequentElements:
    def topKFrequent(self, nums: list[int], k: int) -> list[int]:
        count = Counter(nums)
        # return heapq.nlargest(k, count.keys(), key=count.get)
        heap = []

        for num, freq in count.items():
            if len(heap) < k:
                heapq.heappush(heap, (freq, num))
            else:
                if heap[0][0] < freq:
                    heapq.heappop(heap)
                    heapq.heappush(heap, (freq, num))

        return [num for freq, num in heap]


if __name__ == "__main__":
    solution = TopKFrequentElements()
    nums1 = [1, 1, 1, 2, 2, 3]
    k1 = 2
    print("Expected Output: [1, 2] (order can be arbitrary)")
    print("Actual Output:", solution.topKFrequent(nums1, k1))

    nums2 = [1]
    k2 = 1
    print("Expected Output: [1]")
    print("Actual Output:", solution.topKFrequent(nums2, k2))

    nums3 = [4, 1, -1, 2, -1, 2, 3]
    k3 = 2
    print("Expected Output: [-1, 2] (order can be arbitrary)")
    print("Actual Output:", solution.topKFrequent(nums3, k3))

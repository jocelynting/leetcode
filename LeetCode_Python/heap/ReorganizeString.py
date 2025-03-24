import heapq
from collections import Counter


class ReorganizeString:
    def reorganizeString(self, s: str) -> str:
        freq = Counter(s)
        max_heap = [(-count, char) for char, count in freq.items()]
        heapq.heapify(max_heap)

        res = []
        prev = None

        while max_heap or prev:
            if not max_heap and prev:
                return ""

            count, char = heapq.heappop(max_heap)
            res.append(char)
            count += 1

            if prev:
                heapq.heappush(max_heap, prev)
                prev = None

            if count < 0:
                prev = (count, char)

        return "".join(res)


# Time Complexity: O(nlogn)
# Space Complexity: O(n)

if __name__ == "__main__":
    solution = ReorganizeString()

    print("Expected Output : aba")
    print("Actual Output   :", solution.reorganizeString("aab"))

    print("Expected Output : ")
    print("Actual Output   :", solution.reorganizeString("aaab"))

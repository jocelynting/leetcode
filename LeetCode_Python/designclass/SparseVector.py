class SparseVector:
    def __init__(self, nums: list[int]):
        self.pairs = []
        for i, num in enumerate(nums):
            if num != 0:
                self.pairs.append((i, num))

    def dotProduct(self, vec: "SparseVector") -> int:
        res = 0
        i = j = 0

        while i < len(self.pairs) and j < len(vec.pairs):
            if self.pairs[i][0] == vec.pairs[j][0]:
                res += self.pairs[i][1] * vec.pairs[j][1]
                i += 1
                j += 1
            elif self.pairs[i][0] > vec.pairs[j][0]:
                j += 1
            else:
                i += 1

        return res


# Time Complexity: O(n + m), where n is the number of non-zero elements in the first vector and m is the number of non-zero elements in the second vector.
# Space Complexity: O(n), where n is the number of non-zero elements in the first vector.

if __name__ == "__main__":
    vec1 = SparseVector([1, 0, 0, 2, 3])
    vec2 = SparseVector([0, 3, 0, 4, 0])

    print("Expected Output: 8")
    print("Actual Output:", vec1.dotProduct(vec2))

    vec3 = SparseVector([0, 1, 0, 0])
    vec4 = SparseVector([1, 0, 0, 0])

    print("Expected Output: 0")
    print("Actual Output:", vec3.dotProduct(vec4))

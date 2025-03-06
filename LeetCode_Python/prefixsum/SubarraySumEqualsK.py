class SubarraySumEqualsK:
    def subarraySum(self, nums: list[int], k: int) -> int:
        prefix = 0
        count = {0: 1}
        res = 0

        for num in nums:
            prefix += num
            diff = prefix - k
            if diff in count:
                res += count[diff]
            count[prefix] = count.get(prefix, 0) + 1

        return res


if __name__ == "__main__":
    solution = SubarraySumEqualsK()

    print("Excepcted Output : 2")
    print("Actual Output : ", solution.subarraySum([1, 1, 1], 2))

    print("Excepcted Output : 2")
    print("Actual Output : ", solution.subarraySum([1, 2, 3], 3))

    print("Excepcted Output : 1")
    print("Actual Output : ", solution.subarraySum([1, 2, 3], 6))

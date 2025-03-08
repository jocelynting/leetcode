class MajorityElement:
    def majorityElement(self, nums: list[int]) -> int:
        major, count = 0, 0

        for num in nums:
            if count == 0:
                major = num

            if num == major:
                count += 1
            else:
                count -= 1

        return major


if __name__ == "__main__":
    solution = MajorityElement()

    print("Expected Output : 3")
    print("Actual Output : ", solution.majorityElement([3, 2, 3]))

    print("Expected Output : 2")
    print("Actual Output : ", solution.majorityElement([2, 2, 1, 1, 1, 2, 2]))

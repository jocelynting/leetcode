class LemonadeChange:
    def lemonadeChange(self, bills: list[int]) -> bool:
        five = ten = 0

        for bill in bills:
            if bill == 5:
                five += 1
            elif bill == 10:
                if five == 0:
                    return False
                five -= 1
                ten += 1
            else:
                if ten > 0 and five > 0:
                    ten -= 1
                    five -= 1
                elif five >= 3:
                    five -= 3
                else:
                    return False

        return True


# Time Complexity: O(n), where n is the number of bills
# Space Complexity: O(1), no extra space is used

if __name__ == "__main__":
    solution = LemonadeChange()

    print("Expected Output: True")
    print("Actual Output: ", solution.lemonadeChange([5, 5, 5, 10, 20]))

    print("Expected Output: True")
    print("Actual Output: ", solution.lemonadeChange([5, 5, 10]))

    print("Expected Output: False")
    print("Actual Output: ", solution.lemonadeChange([10, 10]))

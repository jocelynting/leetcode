class AverageSalaryExcludingTheMinimumAndMaximumSalary:
    def average(self, salary: list[int]) -> float:
        min_salary = min(salary)
        max_salary = max(salary)
        total = sum(salary) - min_salary - max_salary
        count = len(salary) - 2

        return total / count


# Time Complexity: O(n), where n is the length of the salary array
# Space Complexity: O(1), no extra space is used

if __name__ == "__main__":
    solution = AverageSalaryExcludingTheMinimumAndMaximumSalary()

    print("Expected Output: 2500.0")
    print("Actual Output: ", solution.average([4000, 3000, 1000, 2000]))

    print("Expected Output: 2000.0")
    print("Actual Output: ", solution.average([1000, 2000, 3000]))

    print("Expected Output: 3500.0")
    print("Actual Output: ", solution.average([6000, 5000, 4000, 3000, 2000, 1000]))

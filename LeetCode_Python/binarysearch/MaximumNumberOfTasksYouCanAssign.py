from collections import deque


class MaximumNumberOfTasksYouCanAssign:
    def maximumTasks(
        self, tasks: list[list[int]], workers: list[int], pills: int, strength: int
    ) -> int:
        tasks.sort()
        workers.sort()

        def can_assign(mid: int) -> bool:
            queue = deque()
            n = len(workers) - 1
            p = pills

            for t in reversed(tasks[:mid]):
                if queue and queue[0] >= t:
                    queue.popleft()
                elif n >= 0 and workers[n] >= t:
                    n -= 1
                else:
                    while n >= 0 and workers[n] + strength >= t:
                        queue.append(workers[n])
                        n -= 1

                    if not queue or p == 0:
                        return False

                    queue.pop()
                    p -= 1

            return True

        left, right = 0, min(len(tasks), len(workers))
        res = 0

        while left <= right:
            mid = (left + right) // 2
            if can_assign(mid):
                res = mid
                left = mid + 1
            else:
                right = mid - 1

        return res


# Time Complexity: O(nlogn + mlogm + log(min(n, m)) * (n + m))
# sorting tasks and workers takes O(nlogn + mlogm)
# each binary search runs log(min(n,m)) times with each check costing O(n+m)
# Space Complexity: O(n + m)

if __name__ == "__main__":
    solution = MaximumNumberOfTasksYouCanAssign()

    tasks = [3, 2, 1]
    workers = [0, 3, 3]
    pills = 1
    strength = 1
    print("Expected Output: 3")
    print("Actual Output:", solution.maximumTasks(tasks, workers, pills, strength))

    tasks = [10, 15, 30]
    workers = [0, 10, 10, 10, 10]
    pills = 3
    strength = 10
    print("Expected Output: 2")
    print("Actual Output:", solution.maximumTasks(tasks, workers, pills, strength))

    tasks = [5, 9, 8, 5, 9]
    workers = [1, 6, 4, 2, 6]
    pills = 1
    strength = 5
    print("Expected Output: 3")
    print("Actual Output:", solution.maximumTasks(tasks, workers, pills, strength))

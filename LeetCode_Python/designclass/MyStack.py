from collections import deque


class MyStack:

    def __init__(self):
        self.queue = deque()

    def push(self, x: int) -> None:
        self.queue.append(x)
        for _ in range(len(self.queue) - 1):
            self.queue.append(self.queue.popleft())

    def pop(self) -> int:
        return self.queue.popleft()

    def top(self) -> int:
        return self.queue[0]

    def empty(self) -> bool:
        return not self.queue


# Time Complexity: O(n) for push, O(1) for pop and top, O(1) for empty
# Space Complexity: O(n) for the queue

if __name__ == "__main__":
    solution = MyStack()

    solution.push(1)
    solution.push(2)
    solution.push(3)

    print("Expected Output: 3")
    print("Actual Output: ", solution.top())

    print("Expected Output: 3")
    print("Actual Output: ", solution.pop())

    print("Expected Output: False")
    print("Actual Output: ", solution.empty())

    solution.pop()
    solution.pop()
    print("Expected Output: True")
    print("Actual Output: ", solution.empty())

    solution.push(4)
    print("Expected Output: 4")
    print("Actual Output: ", solution.top())

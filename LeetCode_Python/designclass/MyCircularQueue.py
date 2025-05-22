class MyCircularQueue:
    def __init__(self, k: int):
        self.queue = [0] * k
        self.head = 0
        self.tail = 0
        self.size = 0
        self.capacity = k

    def enQueue(self, value: int) -> bool:
        if self.size == self.capacity:
            return False
        self.queue[self.tail] = value
        self.tail = (self.tail + 1) % self.capacity
        self.size += 1
        return True

    def deQueue(self) -> bool:
        if self.size == 0:
            return False
        self.head = (self.head + 1) % self.capacity
        self.size -= 1
        return True

    def Front(self) -> int:
        if self.size == 0:
            return -1
        return self.queue[self.head]

    def Rear(self) -> int:
        if self.size == 0:
            return -1
        return self.queue[(self.tail - 1 + self.capacity) % self.capacity]

    def isEmpty(self) -> bool:
        return self.size == 0

    def isFull(self) -> bool:
        return self.size == self.capacity


# Time Complexity:
# - O(1) for all operations (enQueue, deQueue, Front, Rear, isEmpty, isFull)
# Space Complexity:
# - O(k) where k is the size of the circular queue

if __name__ == "__main__":
    solution = MyCircularQueue(3)

    print("Expected Output: True")
    print("Actual Output:", solution.enQueue(1))

    print("Expected Output: True")
    print("Actual Output:", solution.enQueue(2))

    print("Expected Output: True")
    print("Actual Output:", solution.enQueue(3))

    print("Expected Output: False")
    print("Actual Output:", solution.enQueue(4))

    print("Expected Output: 1")
    print("Actual Output:", solution.Front())

    print("Expected Output: 3")
    print("Actual Output:", solution.Rear())

    print("Expected Output: True")
    print("Actual Output:", solution.deQueue())

    print("Expected Output: True")
    print("Actual Output:", solution.enQueue(4))

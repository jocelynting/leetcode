class MyHashMap:

    def __init__(self):
        self.size = 1009  # A prime number for better distribution
        self.buckets = [[] for _ in range(self.size)]

    def hash(self, key: int) -> int:
        return key % self.size

    def bucket(self, key: int) -> list:
        k = self.hash(key)
        return self.buckets[k]

    def put(self, key: int, value: int) -> None:
        bucket = self.bucket(key)
        for i, (k, _) in enumerate(bucket):
            if k == key:
                bucket[i] = (key, value)
                return
        bucket.append((key, value))

    def get(self, key: int) -> int:
        bucket = self.bucket(key)
        for k, v in bucket:
            if k == key:
                return v
        return -1

    def remove(self, key: int) -> None:
        bucket = self.bucket(key)
        for i, (k, _) in enumerate(bucket):
            if k == key:
                del bucket[i]
                return


if __name__ == "__main__":
    myHashMap = MyHashMap()

    # Test case 1: Insert and get operations
    print("Executing put(1, 1)")
    myHashMap.put(1, 1)  # Map: {1: 1}
    print("Executing put(2, 2)")
    myHashMap.put(2, 2)  # Map: {1: 1, 2: 2}
    print("Executing get(1) -> expected output: 1")
    print("Output:", myHashMap.get(1))  # Expected output: 1

    # Test case 2: Update existing key
    print("Executing put(1, 3) to update key 1")
    myHashMap.put(1, 3)  # Update key 1, Map: {1: 3, 2: 2}
    print("Executing get(1) -> expected output: 3")
    print("Output:", myHashMap.get(1))  # Expected output: 3

    # Test case 3: Remove operation
    print("Executing remove(2)")
    myHashMap.remove(2)  # Remove key 2, Map: {1: 3}
    print("Executing get(2) -> expected output: -1")
    print("Output:", myHashMap.get(2))  # Expected output: -1

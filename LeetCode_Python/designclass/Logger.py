class Logger:
    def __init__(self):
        self.logger = {}

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        if message not in self.logger:
            self.logger[message] = timestamp
            return True
        else:
            time = self.logger[message]
            if timestamp < time + 10:
                return False
            else:
                self.logger[message] = timestamp
                return True


if __name__ == "__main__":
    solution = Logger()

    print("Expected Output : True")
    print("Actual Output : ", solution.shouldPrintMessage(1, "foo"))
    print("Expected Output : True")
    print("Actual Output : ", solution.shouldPrintMessage(2, "bar"))
    print("Expected Output : False")
    print("Actual Output : ", solution.shouldPrintMessage(3, "foo"))
    print("Expected Output : False")
    print("Actual Output : ", solution.shouldPrintMessage(8, "bar"))
    print("Expected Output : False")
    print("Actual Output : ", solution.shouldPrintMessage(10, "foo"))
    print("Expected Output : True")
    print("Actual Output : ", solution.shouldPrintMessage(11, "foo"))

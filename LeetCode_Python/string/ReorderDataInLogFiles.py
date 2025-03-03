class ReorderDataInLogFiles:
    def reorderLogFiles(self, logs: list[str]) -> list[str]:
        letter_logs = []
        digit_logs = []

        for log in logs:
            identifier, content = log.split(" ", 1)
            if content[0].isdigit():
                digit_logs.append(log)
            else:
                letter_logs.append(log)

        letter_logs.sort(key=lambda log: (
            log.split(" ", 1)[1], log.split(" ", 1)[0]))

        return letter_logs + digit_logs


if __name__ == '__main__':
    solution = ReorderDataInLogFiles()

    logs1 = ["dig1 8 1 5 1", "let1 art can",
             "dig2 3 6", "let2 own kit dig", "let3 art zero"]
    print("Expected Output:", [
        "let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1", "dig2 3 6"])
    print("Actual Output:", solution.reorderLogFiles(logs1))

    logs2 = ["dig1 8 1 5 1", "dig2 3 6"]
    print("Expected Output:", logs2)
    print("Actual Output:", solution.reorderLogFiles(logs2))

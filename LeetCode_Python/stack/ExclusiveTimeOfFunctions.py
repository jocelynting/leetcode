class ExclusiveTimeOfFunctions:
    def exclusiveTime(self, n: int, logs: list[str]) -> list[int]:
        res = [0] * n
        pre = 0
        stack = []

        for log in logs:
            fid_str, typ, time_str = log.split(":")
            fid, time = int(fid_str), int(time_str)

            if typ == "start":
                if stack:
                    res[stack[-1]] += time - pre
                stack.append(fid)
                pre = time
            else:
                res[stack.pop()] += time - pre + 1
                pre = time + 1

        return res


if __name__ == "__main__":
    solution = ExclusiveTimeOfFunctions()

    print("Expected Output : [3,4]")
    print(
        "Actual Output : ",
        solution.exclusiveTime(2, ["0:start:0", "1:start:2", "1:end:5", "0:end:6"]),
    )

    print("Expected Output : [8]")
    print(
        "Actual Output : ",
        solution.exclusiveTime(
            1, ["0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"]
        ),
    )

    print("Expected Output : [2,2]")
    print(
        "Actual Output : ",
        solution.exclusiveTime(2, ["0:start:0", "0:end:1", "1:start:1", "1:end:2"]),
    )

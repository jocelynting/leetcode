from collections import deque

class CourseSchedule:
    def canFinish(self, numCourses: int, prerequisites: list[list[int]]) -> bool:
        graph = [[] for _ in range(numCourses)]
        indegree = [0] * numCourses

        for pre in prerequisites:
            graph[pre[1]].append(pre[0])
            indegree[pre[0]] += 1
        
        queue = deque()
        for i in range(numCourses):
            if indegree[i] == 0:
                queue.append(i)
        
        course = 0
        while queue:
            node = queue.popleft()
            course += 1

            for nei in graph[node]:
                indegree[nei] -= 1
                if indegree[nei] == 0:
                    queue.append(nei)
        
        return course == numCourses

if __name__ == "__main__":
    solution = CourseSchedule()
    
    # Test Case 1:
    numCourses1 = 2
    prerequisites1 = [[1, 0]]
    print("Test Case 1:")
    print("Input: numCourses =", numCourses1, ", prerequisites =", prerequisites1)
    print("Expected Output: True")
    print("Actual Output:", solution.canFinish(numCourses1, prerequisites1))
    print()
    
    # Test Case 2:
    numCourses2 = 2
    prerequisites2 = [[1, 0], [0, 1]]
    print("Test Case 2:")
    print("Input: numCourses =", numCourses2, ", prerequisites =", prerequisites2)
    print("Expected Output: False")
    print("Actual Output:", solution.canFinish(numCourses2, prerequisites2))
    print()
    
    # Test Case 3:
    numCourses3 = 4
    prerequisites3 = [[1,0],[2,0],[3,1],[3,2]]
    print("Test Case 3:")
    print("Input: numCourses =", numCourses3, ", prerequisites =", prerequisites3)
    print("Expected Output: True")
    print("Actual Output:", solution.canFinish(numCourses3, prerequisites3))
    print()
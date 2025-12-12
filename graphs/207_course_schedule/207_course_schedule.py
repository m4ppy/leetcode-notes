"""
LeetCode 207. Course Schedule
Link: https://leetcode.com/problems/course-schedule/
Difficulty: Medium
Primary: Graph
Tags: [graph, bfs, dfs, topological-sort, cycle-detection]
Solved: 2025-11-14
"""

from typing import List

class Solution:

    # --- Approach 1: Depth First Search ---
    # Time: O(m + n), Space: O(m + n) 
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        preMap = [[] for i in range(numCourses)]
        for crs, pre in prerequisites:
            preMap[crs].append(pre)

        visiting = set()

        def dfs(crs):
            if crs in visiting:
                return False
            
            if preMap[crs] == []:
                return True

            visiting.add(crs)
            for pre in preMap[crs]:
                if not dfs(pre):
                    return False
            visiting.remove(crs)
            preMap[crs] = []
            return True

        for c in range(numCourses):
            if not dfs(c):
                return False
        return True

# --- Example Test ---
if __name__ == "__main__":
    solution = Solution()

    numCourses = 2
    prerequisites = [[1, 0]]
    print(solution.canFinish(numCourses, prerequisites))  # True
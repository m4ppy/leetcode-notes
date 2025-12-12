"""
LeetCode 200. Number of Islands
Link: https://leetcode.com/problems/number-of-islands/
Difficulty: Medium
Primary: Graph
Tags: [graph, bfs, dfs, matrix, connected-components]
Solved: 2025-11-14
"""

from typing import List

class Solution:

    # --- Approach 1: Depth First Search ---
    # Time: O(m * n), Space: O(m * n) 
    def numIslands(self, grid: List[List[str]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])

        def dfs(r, c):
            if r < 0 or c < 0 or r == ROWS or c == COLS or grid[r][c] == '0':
                return 
                
            grid[r][c] = '0' 

            dfs(r + 1, c)
            dfs(r, c - 1)
            dfs(r - 1, c)
            dfs(r, c + 1)

        res = 0
        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == '1':
                    dfs(r, c)    
                    res += 1

        return res
    

# --- Example Test ---
if __name__ == "__main__":
    solution = Solution()
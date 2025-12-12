/*
LeetCode 200. Number of Islands
Link: https://leetcode.com/problems/number-of-islands/
Difficulty: Medium
Primary: Graph
Tags: [graph, bfs, dfs, matrix, connected-components]
Solved: 2025-11-14
*/

class Solution {

    // --- Approach 1: Depth First Search ---
    // Time: O(m * n), Space: O(m * n) 
    private int ROWS;
    private int COLS;

    public int numIslands(char[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        int count = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1') {
                    dfs(r, c, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int row, int col, char[][] grid) {
        if (row < 0 || row == ROWS || col < 0 || col == COLS || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        dfs(row, col + 1, grid);
        dfs(row, col - 1, grid);
        dfs(row + 1, col, grid);
        dfs(row - 1, col, grid);
    }




    // --- Example Test ---
    public static void main(String[] args) {
        Solution sol = new Solution();

        char[][] grid1 = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        System.out.println(sol.numIslands(grid1)); // Expected: 1
    }
    
}
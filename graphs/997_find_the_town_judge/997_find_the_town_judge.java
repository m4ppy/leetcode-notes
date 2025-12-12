/*
LeetCode 997. Find the Town Judge
Link: https://leetcode.com/problems/find-the-town-judge/
Difficulty: Easy
Primary: Graph
Tags: [graph, indegree/outdegree, trust-graph, counting]
Solved: 2025-11-14
*/

class Solution {

    // --- Approach 1: Degree Counting ---
    // Time: O(n), Space: O(n) 
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n + 1];
        for (int[] person : trust) {
            count[person[0]]--;
            count[person[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (count[i] == (n - 1)) return i;
        }
        return -1;
    }


    // --- Example Test ---
    public static void main(String[] args) {
        Solution sol = new Solution();

        int n = 2;
        int[][] trust = {{1, 2}};
        int judge = sol.findJudge(n, trust);
        
        System.out.println(judge); // Expected: 2
    }
    
}
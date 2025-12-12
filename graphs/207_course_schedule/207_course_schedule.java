/*
LeetCode 207. Course Schedule
Link: https://leetcode.com/problems/course-schedule/
Difficulty: Medium
Primary: Graph
Tags: [graph, bfs, dfs, topological-sort, cycle-detection]
Solved: 2025-11-14
*/

import java.util.*;

class Solution {

    // --- Approach 1: Depth First Search ---
    // Time: O(m + n), Space: O(m + n) 
    private Map<Integer, List<Integer>> preMap = new HashMap<>();

    private Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            preMap.get(prereq[0]).add(prereq[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int crs) {
        if (visited.contains(crs)) {
            return false;
        }

        if (preMap.get(crs).isEmpty()) {
            return true;
        }

        visited.add(crs);
        for (int neighbor : preMap.get(crs)) {
            if (!dfs(neighbor)) {
                return false;
            }
        }
        visited.remove(crs);
        preMap.put(crs, new ArrayList<>());

        return true;
    }



    // --- Example Test ---
    public static void main(String[] args) {
        Solution sol = new Solution();

        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        System.out.println(sol.canFinish(numCourses, prerequisites)); // true
    }
    
}
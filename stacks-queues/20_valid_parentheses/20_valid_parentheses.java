/*
LeetCode 20. Valid Parentheses
Link: https://leetcode.com/problems/valid-parentheses/
Difficulty: Easy
Primary: Stack
Tags: [stack, string, bracket-matching]
Solved: 2025-11-12
*/

import java.util.*;

class Solution {

    // --- Approach 1: Brute Force ---
    // Time: O(n²), Space: O(n)
    public boolean isValid_bruteForce(String s) {
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }
        return s.isEmpty();
    }


    // --- Approach 2: Stack ---
    // Time: O(n), Space: O(n)
    public boolean isValid_stack(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');

        for (char c : s.toCharArray()) {
            if (closeToOpen.containsKey(c)) {
                if (!stack.isEmpty() && closeToOpen.get(c) == stack.peek()) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }


    // --- Example Test ---
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "()[]{}";

        System.out.println(sol.isValid_stack(s)); // true
    }
}
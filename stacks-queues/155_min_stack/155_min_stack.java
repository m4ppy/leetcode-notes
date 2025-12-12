/*
LeetCode 155. Min Stack
Link: https://leetcode.com/problems/min-stack/
Difficulty: Medium
Primary: Stack
Tags: [design, stack, data-structure, optimization]
Solved: 2025-11-12
*/

import java.util.*;

// --- Approach 1: One Stack ---
    // Time: O(1), Space: O(n)
class MinStack_OneStack {

    private Stack<int[]> stack;

    public MinStack_OneStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        int min_val;
        if (!stack.isEmpty()) {
            min_val = Math.min(stack.peek()[1], val);
        } else {
            min_val = val;
        }
        stack.push(new int[]{val, min_val});
                
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }


    // --- Example Test ---
    public static void main(String[] args) {
        MinStack_OneStack sol = new MinStack_OneStack();
        
        sol.push(-2);
        sol.push(0);
        sol.push(-3);
        System.out.println(sol.getMin()); // return -3
        sol.pop();
        System.out.println(sol.top());    // return 0
        System.out.println(sol.getMin()); // return -2

    }
}
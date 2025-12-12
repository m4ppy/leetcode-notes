/*
LeetCode 445. Add Two Numbers II
Link: https://leetcode.com/problems/add-two-numbers-ii/
Difficulty: Medium
Primary: Linked List
Tags: [linked-list, stack, math, simulation]
Solved: 2025-11-12
*/

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {

    // --- Approach 1: Reverse List ---
    // Time: O(n²), Space: O(1)
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public ListNode addTwoNumbers_reverseList(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ListNode head = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return head;

    }


    // --- Approach 2: Stack ---
    // Time: O(m + n), Space: O(m + n)
    public ListNode addTwoNumbers_stack(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode head = null;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            int v1 = s1.isEmpty() ? 0 : s1.pop();
            int v2 = s2.isEmpty() ? 0 : s2.pop();
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
        }

        return head;

    }


    // --- Example Test ---
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = sol.addTwoNumbers_stack(l1, l2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
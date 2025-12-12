"""
LeetCode 445. Add Two Numbers II
Link: https://leetcode.com/problems/add-two-numbers-ii/
Difficulty: Medium
Primary: Linked List
Tags: [linked-list, stack, math, simulation]
Solved: 2025-11-12
"""

from typing import List, Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:

    # --- Approach 1: Reverse List ---
    # Time: O(m + n), Space: O(max(m, n))
    def addTwoNumbers_reverse_list(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        def reverseList(head):
            prev, curr = None, head
            while curr:
                temp = curr.next
                curr.next = prev
                prev = curr
                curr = temp
            return prev

        l1 = reverseList(l1)
        l2 = reverseList(l2)

        head = None
        carry = 0
        while l1 or l2 or carry:
            v1 = l1.val if l1 else 0
            v2 = l2.val if l2 else 0
            sum = v1 + v2 + carry
            carry = sum // 10
            node = ListNode(sum % 10)
            node.next = head
            head = node

            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None

        return head
    
    # --- Approach 2: Stack ---
    # Time: O(m + n), Space: O(m + n)
    def addTwoNumbers_stack(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        s1, s2 = [], []
        while l1:
            s1.append(l1.val)
            l1 = l1.next
        
        while l2:
            s2.append(l2.val)
            l2 = l2.next
        
        head = None
        carry = 0
        while s1 or s2 or carry:
            v1 = s1.pop() if s1 else 0
            v2 = s2.pop() if s2 else 0
            sum = v1 + v2 + carry
            carry = sum // 10
            node = ListNode(sum % 10)
            node.next = head
            head = node

        return head
    
    

# --- Example Test ---
if __name__ == "__main__":
    solution = Solution()
    # Example 1
    l1 = ListNode(7, ListNode(2, ListNode(4, ListNode(3))))
    l2 = ListNode(5, ListNode(6, ListNode(4)))
    result = solution.addTwoNumbers_reverse_list(l1, l2)
    # Output the result
    while result:
        print(result.val, end=" -> " if result.next else "\n")
        result = result.next
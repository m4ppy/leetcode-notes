/* 
LeetCode 707. Design Linked List
Link: https://leetcode.com/problems/design-linked-list/
Difficulty: Medium
Primary: Linked List
Tags: [linked-list, design, simulation]
Solved: 2026-06-30
*/

// --- Approach 1: Singly Linked List ---
class MyLinkedList {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private ListNode head;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode p = head;

        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        return p.val;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);

        node.next = head;
        head = node;

        size = size + 1;
    }

    public void addAtTail(int val) {
        if (size == 0) {
            addAtHead(val);
        } else {
            ListNode node = new ListNode(val);

            ListNode p = head;

            while (p.next != null) {
                p = p.next;
            }

            node.next = p.next;
            p.next = node;

            size = size + 1;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            ListNode node = new ListNode(val);

            ListNode p = head;

            for (int i = 0; i < index - 1; i++) {
                p = p.next;
            }

            node.next = p.next;
            p.next = node;

            size = size + 1;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        if (index == 0) {
            head = head.next;
        } else {
            ListNode p = head;

            for (int i = 0; i < index - 1; i++) {
                p = p.next;
            }

            p.next = p.next.next;
        }

        size = size - 1;
    }

    // --- Example Test ---
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);

        System.out.println(linkedList.get(1)); // 2

        linkedList.deleteAtIndex(1);

        System.out.println(linkedList.get(1)); // 3

        // Print entire linked list
        ListNode p = linkedList.head;

        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
}
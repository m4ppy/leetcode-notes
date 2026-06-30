# 707. Design Linked List

**Link:** [LeetCode 707 – Design Linked List](https://leetcode.com/problems/design-linked-list/)
**Difficulty:** Medium
**Primary Topic:** Linked List
**Tags:** [linked-list, design, simulation]
**Languages:** Python, Java
**Solved:** 2026-06-30

---

### 🧩 Problem Summary

Design and implement a singly linked list.

The linked list should support the following operations:

* Get the value of the node at a given index.
* Add a node at the beginning of the list.
* Add a node at the end of the list.
* Add a node before a given index.
* Delete the node at a given index.

If an index is invalid, the operation should not modify the linked list.

---

### 🧠 Approach

#### Approach 1: Singly Linked List

* Define a `ListNode` class containing a value and a pointer to the next node.
* Maintain a `head` pointer to the first node and a `size` variable to track the number of nodes.
* Traverse the list from the head to access, insert, or delete a node at a specific index.
* Validate the index before performing each operation.
* **Time Complexity:**

  * `get`: O(n)
  * `addAtHead`: O(1)
  * `addAtTail`: O(n)
  * `addAtIndex`: O(n)
  * `deleteAtIndex`: O(n)
* **Space Complexity:** O(n)

---

### ⚙️ Supported Operations

| Method                   | Description                                        |
| ------------------------ | -------------------------------------------------- |
| `get(index)`             | Returns the value of the node at the given index   |
| `addAtHead(val)`         | Adds a new node at the beginning of the list       |
| `addAtTail(val)`         | Adds a new node at the end of the list             |
| `addAtIndex(index, val)` | Adds a new node before the node at the given index |
| `deleteAtIndex(index)`   | Deletes the node at the given index                |

---

### 🚀 Approaches Implemented

| Language | File                                                           |
| -------- | -------------------------------------------------------------- |
| Python   | [`707_design_linked_list.py`](./707_design_linked_list.py)     |
| Java     | [`707_design_linked_list.java`](./707_design_linked_list.java) |
| C     | [`707_design_linked_list.c`](./707_design_linked_list.c) |

---

### ✅ Example

```python
Input:
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex",
 "get", "deleteAtIndex", "get"]

[[], [1], [3], [1, 2], [1], [1], [1]]

Output:
[null, null, null, null, 2, null, 3]
```

```text
Initial list: []

addAtHead(1)
1

addAtTail(3)
1 -> 3

addAtIndex(1, 2)
1 -> 2 -> 3

get(1)
2

deleteAtIndex(1)
1 -> 3

get(1)
3
```

from typing import List, Optional

class ListNode:

    def __init__(self, val = 0):
        self.val = val
        self.next = None

class MyLinkedList:

    def __init__(self):
        self.head = None
        self.size = 0

    def get(self, index: int) -> int:
        if index < 0 or index >= self.size:
            return -1
        
        p = self.head
        for _ in range(index):
            p = p.next

        return p.val

    def addAtHead(self, val: int) -> None:
        node = ListNode(val)
        node.next = self.head
        self.head = node

        self.size = self.size + 1

    def addAtTail(self, val: int) -> None:
        if self.size == 0:
            self.addAtHead(val)
        else:
            node = ListNode(val)

            p = self.head
            while p.next != None:
                p = p.next

            node.next = p.next
            p.next = node

            self.size = self.size + 1

    def addAtIndex(self, index: int, val: int) -> None:
        if index < 0 or index > self.size:
            return

        if index == 0:
            self.addAtHead(val)
        elif index == self.size:
            self.addAtTail(val)
        else:
            node = ListNode(val)

            p = self.head
            for _ in range(index - 1):
                p = p.next
            
            node.next = p.next
            p.next = node

            self.size = self.size + 1

    def deleteAtIndex(self, index: int) -> None:
        if index < 0 or index >= self.size:
            return
            
        if index == 0:
            self.head = self.head.next
        else:
            p = self.head   
            for _ in range(index - 1):
                p = p.next

            p.next = p.next.next
        
        self.size = self.size - 1
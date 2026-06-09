#include <stdlib.h>
#include <stdio.h>

typedef struct Node {
    int data;
    struct Node* link;
} Node;

typedef struct {
    Node* head;
    int size;
} MyLinkedList;

MyLinkedList* myLinkedListCreate() {
    MyLinkedList* obj = malloc(sizeof(MyLinkedList));
    obj->head = NULL;
    obj->size = 0;
    return obj;
}

int myLinkedListGet(MyLinkedList* obj, int index) {
    if (index < 0 || index >= obj->size) return -1;

    Node* p = obj->head;

    for (int i = 0; i < index; i++) {
        p = p->link;
    }

    return p->data;
}

void myLinkedListAddAtHead(MyLinkedList* obj, int val) {
    Node* node = malloc(sizeof(Node));
    node->data = val;
    node->link = obj->head;

    obj->head = node;
    obj->size++;
}

void myLinkedListAddAtTail(MyLinkedList* obj, int val) {
    Node* node = malloc(sizeof(Node));
    node->data = val;
    node->link = NULL;

    if (obj->head == NULL) {
        obj->head = node;
    } else {
        Node* p = obj->head;

        while (p->link != NULL) {
            p = p->link;
        }

        p->link = node;
    }

    obj->size++;
}

void myLinkedListAddAtIndex(MyLinkedList* obj, int index, int val) {
    if (index < 0 || index > obj->size) return;

    if (index == 0) {
        myLinkedListAddAtHead(obj, val);
        return;
    }

    if (index == obj->size) {
        myLinkedListAddAtTail(obj, val);
        return;
    }

    Node* prev = obj->head;

    for (int i = 0; i < index - 1; i++) {
        prev = prev->link;
    }

    Node* node = malloc(sizeof(Node));
    node->data = val;
    node->link = prev->link;
    prev->link = node;

    obj->size++;
}

void myLinkedListDeleteAtIndex(MyLinkedList* obj, int index) {
    if (index < 0 || index >= obj->size) return;

    if (index == 0) {
        Node* removed = obj->head;
        obj->head = obj->head->link;
        free(removed);
        obj->size--;
        return;
    }

    Node* prev = obj->head;

    for (int i = 0; i < index - 1; i++) {
        prev = prev->link;
    }

    Node* removed = prev->link;
    prev->link = removed->link;
    free(removed);

    obj->size--;
}

void myLinkedListFree(MyLinkedList* obj) {
    Node* p = obj->head;

    while (p != NULL) {
        Node* removed = p;
        p = p->link;
        free(removed);
    }

    free(obj);
}
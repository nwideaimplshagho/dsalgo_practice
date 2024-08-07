package org.educative.linkedlist.common;

public class LinkedListNode<T> {
    T value;
    LinkedListNode<T> next;

    public LinkedListNode(T value) {
        this.value = value;
        next = null;
    }
}
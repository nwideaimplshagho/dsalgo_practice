package org.educative.linkedlist.common;

public class DoublyLinkedListNode {
    public int data;
    public DoublyLinkedListNode prev;
    public DoublyLinkedListNode next;

    public DoublyLinkedListNode(int data, DoublyLinkedListNode prev, DoublyLinkedListNode next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public DoublyLinkedListNode(int data) {
        this(data, null, null);
    }
}

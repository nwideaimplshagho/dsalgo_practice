package org.educative.linkedlist.common;

public class DoublyLinkedList {

    public DoublyLinkedListNode head;

    public DoublyLinkedList() {
        this.head = null;
    }

    public void insertNodeAtHead(DoublyLinkedListNode node) {
        if (head != null) {
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            head = node;
        }
    }
}

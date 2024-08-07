package org.educative.linkedlist.common;

import java.util.Objects;

import org.educative.linkedlist.examples.LinkedListInsertAtTail;

public class SingleLinkedList<T> {
    LinkedListNode<T> head;
    LinkedListNode<T> tail;
    int size;

    public SingleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return Objects.isNull(head) && Objects.isNull(tail);
    }

    public void insertEnd(T value) {
        LinkedListNode<T> newNode = new LinkedListNode(value);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = this.head;
            size++;
            return;
        }

        tail.next = newNode;
        size++;
    }

    public void insertStart(T value) {
        LinkedListNode<T> newNode = new LinkedListNode(value);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = this.head;
            size++;
            return;
        }

        newNode.next = this.head;
        this.head = newNode;

        size++;
    }

    public void insertAfter(T value, T after) {
        LinkedListNode<T> newNode = new LinkedListNode(value);
        if (isEmpty()) {
            this.head = newNode;
            this.tail = this.head;
            size++;
            return;
        }
        LinkedListNode<T> traverseNode = this.head;
        boolean isMatch = false;
        while (Objects.nonNull(traverseNode)) {
            if (traverseNode.value.equals(after)) {
                isMatch = true;
                break;
            }
            traverseNode = traverseNode.next;
        }


        if (isMatch) {
            //Insert tail
            if (Objects.isNull(traverseNode.next)) {
                insertEnd(value);
            } else {
                //Insert middle
                newNode.next = traverseNode.next;
                traverseNode.next = newNode;
            }
            size++;
        }
    }
}

package org.educative.linkedlist.examples;

import java.util.Objects;

public class LinkedListInsertAtTail {
    public static LinkedListNode<Integer> insertAtTail(LinkedListNode<Integer> head, int value) {

        if (Objects.isNull(head)) {
            head = new LinkedListNode<>(value);
            return head;
        }

        if (Objects.isNull(head.next)) {
            head.next = new LinkedListNode<>(value);
            return head;
        }
        LinkedListNode<Integer> nextNode = head.next;

        while (Objects.nonNull(nextNode)) {
            if (Objects.isNull(nextNode.next)) {
                nextNode.next = new LinkedListNode<>(value);
                break;
            }
            nextNode = nextNode.next;
        }

        return head;
    }
}

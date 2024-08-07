package org.educative.linkedlist.examples;

import java.util.Objects;

public class SearchNodeInLinkedList {
    public static boolean searchNode(LinkedListNode <Integer> head, int value) {

        if (Objects.isNull(head)) {
            return false;
        }

        LinkedListNode<Integer> traverseNode = head;

        while (Objects.nonNull(traverseNode)) {
            if (traverseNode.data == value) {
                return true;
            }
            traverseNode = traverseNode.next;
        }

        return false;
    }
}

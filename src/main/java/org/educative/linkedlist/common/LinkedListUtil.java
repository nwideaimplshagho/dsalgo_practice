package org.educative.linkedlist.common;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.educative.linkedlist.examples.LinkedListNode;

@UtilityClass
@Slf4j
public class LinkedListUtil {
    public static org.educative.linkedlist.examples.LinkedListNode<Integer> getLinkedList(int[] inpArr) {
        org.educative.linkedlist.examples.LinkedListNode<Integer> newNode = null;
        org.educative.linkedlist.examples.LinkedListNode<Integer> head = null;
        int idx = 0;
        while (idx < inpArr.length) {
            int data = inpArr[idx];
            if (newNode == null) {
                newNode = new org.educative.linkedlist.examples.LinkedListNode<>(data);
                head = newNode;
            } else {
                newNode.setNext(new LinkedListNode<>(data));
                newNode = newNode.getNext();
            }
            idx++;
        }

        printList(head, "getLinkedList");

        return head;
    }

    public static void printList(org.educative.linkedlist.examples.LinkedListNode<Integer> head, @NonNull String callerMethod) {
        org.educative.linkedlist.examples.LinkedListNode<Integer> traverseNode = head;

        while (traverseNode != null) {
            log.info("{} !!! Value is {}", callerMethod, traverseNode.getData());
            traverseNode = traverseNode.getNext();
        }
    }
}

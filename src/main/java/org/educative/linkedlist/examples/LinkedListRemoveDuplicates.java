package org.educative.linkedlist.examples;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LinkedListRemoveDuplicates {

    public static LinkedListNode < Integer > removeDuplicates(LinkedListNode < Integer > head) {

        LinkedListNode<Integer> orgNode = head;
        LinkedListNode<Integer> duplicateNode = head;

        while (orgNode != null) {
            if (duplicateNode.next != null && orgNode.data.equals(duplicateNode.next.data)) {
                duplicateNode.next = duplicateNode.next.next;
                continue;
            }

            duplicateNode = duplicateNode.next;

            if (duplicateNode == null || duplicateNode.next == null) {
                orgNode = orgNode.next;
                duplicateNode = orgNode;
            }
        }

        return head;
    }

//    private static void printList(LinkedListNode<Integer> head, @NonNull String callerMethod) {
//        LinkedListNode<Integer> traverseNode = head;
//
//        while (traverseNode != null) {
//            log.info("{} !!! Value is {}", callerMethod, traverseNode.data);
//            traverseNode = traverseNode.next;
//        }
//    }

    public static void main(String[] args) {
//        printList(removeDuplicates(getLinkedList(new int[] {1,2,2,4})), "main");
//        printList(removeDuplicates(getLinkedList(new int[] {9})), "main");
//        printList(removeDuplicates(getLinkedList(new int[] {-1,-1,6,6,9})), "main");
//        printList(removeDuplicates(getLinkedList(new int[] {-1,-1,-1,-1,-1})), "main");
    }

//    private static LinkedListNode<Integer> getLinkedList(int[] inpArr) {
//        LinkedListNode<Integer> newNode = null;
//        LinkedListNode<Integer> head = null;
//        int idx = 0;
//        while (idx < inpArr.length) {
//            int data = inpArr[idx];
//            if (newNode == null) {
//                newNode = new LinkedListNode<>(data);
//                head = newNode;
//            } else {
//                newNode.next = new LinkedListNode<>(data);
//                newNode = newNode.next;
//            }
//            idx++;
//        }
//
//        printList(head, "getLinkedList");
//
//        return head;
//    }
}

package org.educative.linkedlist.examples;

public class FindMiddleInLinkedList {
    public static LinkedListNode<Integer> findMiddle(LinkedListNode<Integer> head) {

        LinkedListNode<Integer>fast = head.next; // will move two steps at a time
        LinkedListNode<Integer>slow = head; //will move one step at a time

        while (fast != null) {
            fast = fast.next == null ? fast.next  : fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
